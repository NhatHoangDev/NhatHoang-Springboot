package com.example.springbootone2manyunidrirectional.service;

import com.example.springbootone2manyunidrirectional.jpa.Book;
import com.example.springbootone2manyunidrirectional.repository.IBookRepository;
import com.example.springbootone2manyunidrirectional.repository.ILibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository bookRepository;
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public int checkId(Integer id) {
       return 0;
    }
}
