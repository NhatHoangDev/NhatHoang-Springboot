package com.example.application.service;

import com.example.application.jpa.Publisher;
import com.example.application.repository.IPublisherReposiroty;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class PublisherService implements IPublisherService {
    private final IPublisherReposiroty publisherReposiroty;

    @Override
    public List<Publisher> findAll() {
        return publisherReposiroty.findAll();
    }

    @Override
    public Optional<Publisher> findById(Integer id) {
        return publisherReposiroty.findById(id);
    }

    @Override
    public Publisher save(Publisher publisher) {
        return publisherReposiroty.save(publisher);
    }

    @Override
    public void remove(Integer id) {
        publisherReposiroty.deleteById(id);
    }
}
