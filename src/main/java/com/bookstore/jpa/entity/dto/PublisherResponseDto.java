package com.bookstore.jpa.entity.dto;

import java.util.UUID;

public record PublisherResponseDto(UUID id,
                                   String name) {
}
