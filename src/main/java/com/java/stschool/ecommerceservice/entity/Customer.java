package com.java.stschool.ecommerceservice.entity;

import com.java.stschool.ecommerceservice.enums.Gender;
import com.java.stschool.ecommerceservice.enums.Status;
import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime lastLoggedInAt;

}
