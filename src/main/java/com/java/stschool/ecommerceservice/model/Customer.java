package com.java.stschool.ecommerceservice.model;

import com.java.stschool.ecommerceservice.enums.Gender;
import com.java.stschool.ecommerceservice.enums.Status;
import lombok.Data;
import org.springframework.core.StandardReflectionParameterNameDiscoverer;

import java.time.LocalDateTime;

@Data
public class Customer {
    private int id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Gender gender;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime lastLoggedInAt;

}
