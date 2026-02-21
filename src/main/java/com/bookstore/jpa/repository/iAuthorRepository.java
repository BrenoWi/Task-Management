package com.bookstore.jpa.repository;

import com.bookstore.jpa.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface iAuthorRepository extends JpaRepository<Author, UUID> {
}
