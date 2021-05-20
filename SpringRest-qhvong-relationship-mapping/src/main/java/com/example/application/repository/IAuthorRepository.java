package com.example.application.repository;

import com.example.application.jpa.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepository extends JpaRepository<Author, Integer> {
}
