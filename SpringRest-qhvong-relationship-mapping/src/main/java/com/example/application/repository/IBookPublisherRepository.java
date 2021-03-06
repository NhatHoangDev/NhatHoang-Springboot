package com.example.application.repository;

import com.example.application.jpa.BookPublisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookPublisherRepository extends JpaRepository<BookPublisher, Integer> {
}
