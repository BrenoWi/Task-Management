package com.bookstore.jpa.service;

import com.bookstore.jpa.entity.Publisher;
import com.bookstore.jpa.entity.dto.PublisherRequestDto;
import com.bookstore.jpa.repository.IPublisherRepository;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
    private final IPublisherRepository publisherRepository;

    public PublisherService(IPublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public Publisher savePublisher(PublisherRequestDto publisherRequestDto){
        if(publisherRepository.existsByName(publisherRequestDto.name())){
            throw new RuntimeException("Publisher already exists in database.");
        }
        Publisher publisher = new Publisher();
        publisher.setName(publisherRequestDto.name());

        return publisherRepository.save(publisher);
    }
}
