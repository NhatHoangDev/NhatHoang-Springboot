package com.example.application.unidirectional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ILibraryRepository extends JpaRepository<Library, Integer> {
}
