package com.bookstore.jpa.entity.dto;

import java.util.Set;
import java.util.UUID;

public record BookDto(String title,
                      UUID publisherId,
                      Set<UUID> authorsIds,
                      String reviewComment) {
}
