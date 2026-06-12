package com.java.stschool.ecommerceservice.service;

import com.java.stschool.ecommerceservice.exception.CustomerExistsException;
import com.java.stschool.ecommerceservice.exception.CustomerNotFoundException;
import com.java.stschool.ecommerceservice.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer) throws CustomerExistsException;
    Customer getById(int id) throws CustomerNotFoundException;
    Customer update(Customer customer) throws CustomerNotFoundException;
    List<Customer> getAll();
    void delete(int id) throws CustomerNotFoundException;
}
