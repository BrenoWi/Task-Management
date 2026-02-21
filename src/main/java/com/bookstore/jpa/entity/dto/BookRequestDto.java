package com.bookstore.jpa.entity.dto;

import java.util.Set;
import java.util.UUID;

public record BookRequestDto(String title,
                             UUID publisherId,
                             Set<UUID> authorsIds,
                             String reviewComment) {
}
