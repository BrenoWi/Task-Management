package com.bookstore.jpa.controller;

import com.bookstore.jpa.entity.Author;
import com.bookstore.jpa.entity.dto.AuthorRequestDto;
import com.bookstore.jpa.entity.dto.AuthorResponseDto;
import com.bookstore.jpa.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookstore/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<AuthorResponseDto> saveAuthor(@RequestBody @Valid AuthorRequestDto authorRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.saveAuthor(authorRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> getAuthorById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(authorService.findAuthorById(id));
    }
}
