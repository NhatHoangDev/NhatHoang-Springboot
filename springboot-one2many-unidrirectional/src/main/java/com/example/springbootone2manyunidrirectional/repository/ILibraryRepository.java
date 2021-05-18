package com.example.springbootone2manyunidrirectional.repository;

import com.example.springbootone2manyunidrirectional.jpa.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILibraryRepository extends JpaRepository<Library, Integer> {
}
