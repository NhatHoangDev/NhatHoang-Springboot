package com.example.springbootone2manyunidrirectional.api;

import com.example.springbootone2manyunidrirectional.jpa.Book;
import com.example.springbootone2manyunidrirectional.jpa.Library;
import com.example.springbootone2manyunidrirectional.repository.IBookRepository;
import com.example.springbootone2manyunidrirectional.repository.ILibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    private IBookRepository bookRepository;
    private ILibraryRepository libraryRepository;
    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book ){
        Optional<Library> libraryOptional = libraryRepository.findById(book.getLibrary().getId());
        if (!libraryOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        book.setLibrary(libraryOptional.get());
        Book bookSaved = bookRepository.save(book);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(bookSaved.getId()).toUri();
        return ResponseEntity.created(location).body(bookSaved);
    }
    @GetMapping("/")
    public ResponseEntity<Page<Book>> getAllBook(Pageable pageable){
        return ResponseEntity.ok(bookRepository.findAll(pageable));
    }
}
