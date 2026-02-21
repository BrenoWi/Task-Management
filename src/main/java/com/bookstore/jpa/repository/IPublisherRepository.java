package com.bookstore.jpa.repository;

import com.bookstore.jpa.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IPublisherRepository extends JpaRepository<Publisher, UUID> {
    boolean existsByName(String name);
}
