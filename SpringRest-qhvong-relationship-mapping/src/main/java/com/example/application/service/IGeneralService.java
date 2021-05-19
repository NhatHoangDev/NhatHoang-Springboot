package com.example.application.service;

import java.util.List;
import java.util.Optional;

public interface IGenericService<T> {
    List<T> findAll();// lay tat ca
    Optional<T> findById(Integer id);
    T save(T t);
    void remove(Integer id);

}
