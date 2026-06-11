package com.java.stschool.ecommerceservice.controller;

import com.java.stschool.ecommerceservice.exception.CustomerExistsException;
import com.java.stschool.ecommerceservice.model.Customer;
import com.java.stschool.ecommerceservice.service.impl.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerServiceImpl customerService;
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Customer customer){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customer));
        }catch (CustomerExistsException ex){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
}
