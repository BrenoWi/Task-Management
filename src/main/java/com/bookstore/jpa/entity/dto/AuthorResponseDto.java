package com.bookstore.jpa.entity.dto;

import java.util.UUID;

public record AuthorResponseDto(UUID id,
                                String name) {
}
