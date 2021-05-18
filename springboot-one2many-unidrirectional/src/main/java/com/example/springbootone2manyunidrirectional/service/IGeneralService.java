package com.example.springbootone2manyunidrirectional.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    List<T> findAll();//lấy toàn bộ danh sách
    Optional<T> findById(Integer id);//lấy theo id
    T save(T t);//tạo mới
    void deleteById(Integer id);//xóa theo id
    int checkId(Integer id);//check id
}
