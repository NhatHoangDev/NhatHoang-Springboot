package com.example.application.service;

import com.example.application.jpa.Author;
import com.example.application.repository.IAuthorRepository;
import com.example.application.service.IService.IAuthorService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class AuthorService implements IAuthorService {
    private final IAuthorRepository authorRepository;


    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Integer id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void remove(Integer id) {
        authorRepository.deleteById(id);
    }
}
