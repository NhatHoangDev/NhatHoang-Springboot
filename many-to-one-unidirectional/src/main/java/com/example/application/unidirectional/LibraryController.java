package com.example.application.unidirectional;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;

import java.net.URI;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/libraries")
public class LibraryController {
    private final ILibraryRepository libraryRepository;
    private final IBookRepository bookRepository;
    @PostMapping("/")
    public ResponseEntity<Library> create(@Valid @RequestBody Library library){
        Library savedLibrary = libraryRepository.save(library);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedLibrary.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedLibrary);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Library> update(@PathVariable Integer id,@Valid @RequestBody Library library){
        Optional<Library> libraryOptional = libraryRepository.findById(id);
        if (!libraryOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        library.setId(libraryOptional.get().getId());
        libraryRepository.save(library);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Library> deleteById(@PathVariable Integer id){
        Optional<Library> libraryOptional = libraryRepository.findById(id);
        if (!libraryOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        deleteByIdInTransactional(libraryOptional.get());
        return ResponseEntity.noContent().build();
    }
    @Transactional
    public void deleteByIdInTransactional(Library library){
        bookRepository.deleteByLibraryId(library.getId());
        libraryRepository.delete(library);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Library> getById(@PathVariable Integer id) {
        Optional<Library> libraryOptional = libraryRepository.findById(id);
        if (!libraryOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(libraryOptional.get());
    }
    @GetMapping("/")
    public ResponseEntity<Page<Library>> getAll(Pageable pageable) {
        return ResponseEntity.ok(libraryRepository.findAll(pageable));
    }

}
