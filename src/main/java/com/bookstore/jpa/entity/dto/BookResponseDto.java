package com.bookstore.jpa.entity.dto;

import java.util.Set;
import java.util.UUID;

public record BookResponseDto(
        UUID id,
        String title,
        String publisher,
        Set<String> authors,
        String reviewComment
) {
}