package com.bookstore.jpa.mapper;

import com.bookstore.jpa.entity.Author;
import com.bookstore.jpa.entity.Book;
import com.bookstore.jpa.entity.dto.BookResponseDto;

import java.util.Set;
import java.util.stream.Collectors;

public class BookMapper {
    public static BookResponseDto toDto(Book book) {
        Set<String> authorNames = book.getAuthors()
                .stream()
                .map(Author::getName)
                .collect(Collectors.toSet());

        return new BookResponseDto(
                book.getId(),
                book.getTitle(),
                book.getPublisher().getName(),
                authorNames,
                book.getReview().getComment()
        );
    }
}
