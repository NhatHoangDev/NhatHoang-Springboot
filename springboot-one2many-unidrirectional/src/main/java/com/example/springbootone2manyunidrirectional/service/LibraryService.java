package com.example.springbootone2manyunidrirectional.service;

import com.example.springbootone2manyunidrirectional.jpa.Library;
import com.example.springbootone2manyunidrirectional.repository.ILibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LibraryService implements ILibraryService{
    @Autowired
    private ILibraryRepository libraryRepository;
    @Override
    public List<Library> findAll() {
        return libraryRepository.findAll();
    }

    @Override
    public Optional<Library> findById(Integer id) {
        return libraryRepository.findById(id);
    }

    @Override
    public Library save(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public void deleteById(Integer id) {
        libraryRepository.deleteById(id);
    }

    @Override
    public int checkId(Integer id) {
        if (!libraryRepository.findById(id).isPresent()){
            return 0;
        }
        return 1;
    }
}
