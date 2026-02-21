package com.bookstore.jpa.entity.dto;

import java.util.Set;

public record BookResponseDto(
        Long id,
        String title,
        String publisher,
        Set<String> authors,
        String reviewComment
) {
}