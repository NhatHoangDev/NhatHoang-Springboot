package com.example.springbootone2manyunidrirectional.api;

import com.example.springbootone2manyunidrirectional.jpa.Library;
import com.example.springbootone2manyunidrirectional.repository.IBookRepository;
import com.example.springbootone2manyunidrirectional.repository.ILibraryRepository;
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

    @PostMapping
    public ResponseEntity<Library> createLibrary(@Valid @RequestBody Library library) {
        Library librarySave = libraryRepository.save(library);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(librarySave.getId()).toUri();
        return ResponseEntity.created(location).body(librarySave);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Library> deleteLibrary(@PathVariable Integer id) {
        //check xem co ton tai id có tồn tại không
        Optional<Library> libraryOptional = libraryRepository.findById(id);
        if (!libraryOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        deleteLibraryCustomTransactional(libraryOptional.get());
        return ResponseEntity.noContent().build();
    }

    @Transactional
    public void deleteLibraryCustomTransactional(Library library) {
        bookRepository.deleteByLibraryId(library.getId());
        libraryRepository.delete(library);
    }

    @GetMapping
    public ResponseEntity<Page<Library>> getAll(Pageable pageable) {
        return ResponseEntity.ok(libraryRepository.findAll(pageable));
    }

}
