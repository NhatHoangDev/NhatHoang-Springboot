package com.example.jparelationships.repository;

import com.example.jparelationships.jpa.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPublisherRepository extends JpaRepository<Publisher, Long> {
}
