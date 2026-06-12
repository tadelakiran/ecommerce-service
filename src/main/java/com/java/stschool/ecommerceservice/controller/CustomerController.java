package com.java.stschool.ecommerceservice.controller;

import com.java.stschool.ecommerceservice.entity.Customer;
import com.java.stschool.ecommerceservice.service.impl.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerServiceImpl customerService;
    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody Customer customer){
            return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customer));
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAll(){
        return ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable int id){

            return ResponseEntity.ok(customerService.getById(id));
    }

    @PutMapping
    public ResponseEntity<Customer> update(@RequestBody Customer customer){
            return ResponseEntity.ok(customerService.update(customer));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
            customerService.delete(id);
            return ResponseEntity.noContent().build();
    }

}
