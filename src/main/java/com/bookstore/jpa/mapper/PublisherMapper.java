package com.bookstore.jpa.mapper;

import com.bookstore.jpa.entity.Publisher;
import com.bookstore.jpa.entity.dto.PublisherResponseDto;

public class PublisherMapper {
    public static PublisherResponseDto toDto(Publisher publisher){
        return new PublisherResponseDto(publisher.getId(), publisher.getName());
    }
}
