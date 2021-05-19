package com.example.application.repository;

import com.example.application.jpa.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherReposiroty extends JpaRepository<Publisher, Integer> {
}
