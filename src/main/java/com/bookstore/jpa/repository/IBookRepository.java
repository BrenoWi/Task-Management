package com.bookstore.jpa.repository;

import com.bookstore.jpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface IBookRepository extends JpaRepository<Book, UUID> {

    Book findByTitle(String title);

    boolean existsByTitle(String title);

    @Query(value = "SELECT * FROM book WHERE publisher_id = :id", nativeQuery = true)
    List<Book> findByPublisherId(@Param("id") UUID id);
}
