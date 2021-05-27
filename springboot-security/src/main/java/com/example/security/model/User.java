package com.example.security.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @Transient
    private String confirmPassword;
    @ManyToMany
    private Set<Role> roles;
}
