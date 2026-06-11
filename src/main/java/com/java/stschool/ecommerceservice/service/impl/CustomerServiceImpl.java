package com.java.stschool.ecommerceservice.service.impl;

import com.java.stschool.ecommerceservice.enums.Status;
import com.java.stschool.ecommerceservice.exception.CustomerExistsException;
import com.java.stschool.ecommerceservice.exception.CustomerNotFoundException;
import com.java.stschool.ecommerceservice.model.Customer;
import com.java.stschool.ecommerceservice.repository.CustomerRepository;
import com.java.stschool.ecommerceservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) throws CustomerExistsException {
        customerRepository.findByEmail(customer.getEmail()).ifPresent(c->{
                  throw new CustomerExistsException("Customer exists with email : " + customer.getEmail());});
        customer.setStatus(Status.ACTIVE);
        customer.setCreatedAt(LocalDateTime.now());
        customer.setLastLoggedInAt(LocalDateTime.now());
        return customerRepository.save(customer);
    }

    @Override
    public Customer getById(int id) throws CustomerNotFoundException {
      return  customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException("customer not found with id : " + id));

    }

    @Override
    public Customer update(Customer customer) throws CustomerNotFoundException {
        customerRepository.findById(customer.getId()).orElseThrow(()->
            new CustomerNotFoundException("customer not found with id : " + customer.getId())
        );
        return customerRepository.update(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public void delete(int id) throws CustomerNotFoundException {
        customerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException("customer not found with id ; "+id));
        customerRepository.deleteById(id);
    }
}
