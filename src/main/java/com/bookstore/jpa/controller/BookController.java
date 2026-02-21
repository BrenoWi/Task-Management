package com.bookstore.jpa.controller;

import com.bookstore.jpa.entity.dto.BookRequestDto;
import com.bookstore.jpa.entity.dto.BookResponseDto;
import com.bookstore.jpa.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookstore/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookResponseDto> saveBook(@RequestBody @Valid BookRequestDto bookRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(bookRequestDto));
    }
}
