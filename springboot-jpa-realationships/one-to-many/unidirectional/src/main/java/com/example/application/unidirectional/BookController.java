package com.example.application.unidirectional;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private final ILibraryRepository libraryRepository;
    private final IBookRepository bookRepository;

    @PostMapping
    public ResponseEntity<Book> create(@Valid @RequestBody Book book) {
        Optional<Library> libraryOptional = libraryRepository.findById(book.getLibrary().getId());
        if (!libraryOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        book.setLibrary(libraryOptional.get());
        Book saveBook = bookRepository.save(book);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saveBook.getId())
                .toUri();
        return ResponseEntity.created(location).body(saveBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Integer id, @Valid @RequestBody Book book) {
        Optional<Library> libraryOptional = libraryRepository.findById(book.getLibrary().getId());
        if (!libraryOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (!bookOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        book.setLibrary(libraryOptional.get());
        book.setId(id);
        bookRepository.save(book);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> delete(@Valid @PathVariable Integer id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (!bookOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Book>> getAll(Pageable pageable) {
        return ResponseEntity.ok(bookRepository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@Valid @PathVariable Integer id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (!bookOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(bookOptional.get());
    }

    @GetMapping("/library/{libraryId}")
    public ResponseEntity<Page<Book>> getByLibraryId(@PathVariable Integer libraryId, Pageable pageable) {
        return ResponseEntity.ok(bookRepository.findByLibraryId(libraryId, pageable));
    }
}
