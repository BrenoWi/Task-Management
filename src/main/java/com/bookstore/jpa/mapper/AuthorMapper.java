package com.bookstore.jpa.mapper;

import com.bookstore.jpa.entity.Author;
import com.bookstore.jpa.entity.dto.AuthorResponseDto;

public class AuthorMapper {
    public static AuthorResponseDto toDto(Author author) {
        return new AuthorResponseDto(
                author.getId(),
                author.getName()
        );
    }
}
