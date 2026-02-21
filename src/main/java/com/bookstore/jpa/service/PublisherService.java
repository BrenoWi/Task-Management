package com.bookstore.jpa.service;

import com.bookstore.jpa.entity.Publisher;
import com.bookstore.jpa.entity.dto.PublisherDto;
import com.bookstore.jpa.repository.IPublisherRepository;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
    private final IPublisherRepository publisherRepository;

    public PublisherService(IPublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public Publisher savePublisher(PublisherDto publisherDto){
        if(publisherRepository.existsByName(publisherDto.name())){
            throw new RuntimeException("Publisher already exists in database.");
        }
        Publisher publisher = new Publisher();
        publisher.setName(publisherDto.name());

        return publisherRepository.save(publisher);
    }
}
