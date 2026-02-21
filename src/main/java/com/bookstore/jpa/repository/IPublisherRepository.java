package com.bookstore.jpa.repository;

import com.bookstore.jpa.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPublisherRepository extends JpaRepository<Publisher, Long> {
    boolean existsByName(String name);
    Optional<Publisher> findByName(String name);
}
