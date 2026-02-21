package com.bookstore.jpa.service;

import com.bookstore.jpa.entity.Publisher;
import com.bookstore.jpa.entity.dto.PublisherRequestDto;
import com.bookstore.jpa.entity.dto.PublisherResponseDto;
import com.bookstore.jpa.mapper.PublisherMapper;
import com.bookstore.jpa.repository.IPublisherRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
    private final IPublisherRepository publisherRepository;

    public PublisherService(IPublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public PublisherResponseDto savePublisher(PublisherRequestDto publisherRequestDto){
        if(publisherRepository.existsByName(publisherRequestDto.name())){
            throw new RuntimeException("Publisher already exists in database.");
        }
        Publisher publisher = new Publisher();
        publisher.setName(publisherRequestDto.name());

        return PublisherMapper.toDto(publisherRepository.save(publisher));
    }

    public PublisherResponseDto getPublisherById(Long id){
        return PublisherMapper.toDto(publisherRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Publisher not found.")));
    }
}
