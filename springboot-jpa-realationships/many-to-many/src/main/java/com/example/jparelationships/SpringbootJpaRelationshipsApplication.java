package com.example.jparelationships;

import com.example.jparelationships.jpa.Book;
import com.example.jparelationships.jpa.Publisher;
import com.example.jparelationships.repository.IBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringbootJpaRelationshipsApplication implements CommandLineRunner {
    @Autowired
    private IBookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaRelationshipsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.save(new Book("Book 1",
                new Publisher("Publisher A"),
                new Publisher("Publisher B")));
    }
}
