package com.bookstore.jpa.entity.dto;

import java.util.Set;

public record BookRequestDto(String title,
                             String publisherName,
                             Set<String> authors,
                             String reviewComment) {
}
