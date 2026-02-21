package com.bookstore.jpa.controller;

import com.bookstore.jpa.entity.dto.PublisherRequestDto;
import com.bookstore.jpa.entity.dto.PublisherResponseDto;
import com.bookstore.jpa.service.PublisherService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookstore/publisher")
public class PublisherController {
    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping
    public ResponseEntity<PublisherResponseDto> savePublisher(@RequestBody @Valid PublisherRequestDto publisherRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(publisherService.savePublisher(publisherRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherResponseDto> getPublisherById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(publisherService.getPublisherById(id));
    }
}
