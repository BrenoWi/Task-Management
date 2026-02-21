package com.bookstore.jpa.entity.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthorRequestDto(@NotBlank(message = "Author name is required") String name) {
}
