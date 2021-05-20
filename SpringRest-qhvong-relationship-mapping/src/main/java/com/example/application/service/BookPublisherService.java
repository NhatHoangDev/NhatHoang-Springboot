package com.example.application.service;

import com.example.application.jpa.BookPublisher;
import com.example.application.repository.IBookPublisherRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class BookPublisherService implements IBookPublisherService {
    private final IBookPublisherRepository bookPublisherRepository;

    @Override
    public List<BookPublisher> findAll() {
        return bookPublisherRepository.findAll();
    }

    @Override
    public Optional<BookPublisher> findById(Integer id) {
        return bookPublisherRepository.findById(id);
    }

    @Override
    public BookPublisher save(BookPublisher bookPublisher) {
        return bookPublisherRepository.save(bookPublisher);
    }

    @Override
    public void remove(Integer id) {
        bookPublisherRepository.deleteById(id);
    }
}
