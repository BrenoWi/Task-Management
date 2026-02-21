package com.bookstore.jpa.controller;

import com.bookstore.jpa.entity.dto.BookRequestDto;
import com.bookstore.jpa.entity.dto.BookResponseDto;
import com.bookstore.jpa.service.BookService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> getBookById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookById(id));
    }
}
