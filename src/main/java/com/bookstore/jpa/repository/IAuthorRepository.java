package com.bookstore.jpa.repository;

import com.bookstore.jpa.entity.Author;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface IAuthorRepository extends JpaRepository<Author, UUID> {
    boolean existsByName(String name);
    Optional<Author> findByName(String name);
}
