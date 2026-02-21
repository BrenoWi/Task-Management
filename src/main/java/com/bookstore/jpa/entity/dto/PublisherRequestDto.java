package com.bookstore.jpa.entity.dto;

import jakarta.validation.constraints.NotBlank;

public record PublisherRequestDto(@NotBlank(message = "Publisher name is required") String name) {
}
