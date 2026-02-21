package com.bookstore.jpa.service;

import com.bookstore.jpa.entity.Author;
import com.bookstore.jpa.entity.Book;
import com.bookstore.jpa.entity.Review;
import com.bookstore.jpa.entity.dto.BookRequestDto;
import com.bookstore.jpa.repository.IAuthorRepository;
import com.bookstore.jpa.repository.IBookRepository;
import com.bookstore.jpa.repository.IPublisherRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class BookService {
    private final IBookRepository bookRepository;
    private final IAuthorRepository authorRepository;
    private final IPublisherRepository publisherRepository;

    public BookService(IBookRepository bookRepository, IAuthorRepository authorRepository, IPublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Transactional
    public Book saveBook(BookRequestDto bookRequestDto){
        if (bookRepository.existsByTitle(bookRequestDto.title())){
            throw new RuntimeException("Book already exists in database.");
        }
        Book book = new Book();
        book.setTitle(bookRequestDto.title());
        book.setPublisher(publisherRepository.findById(bookRequestDto.publisherId()).orElseThrow(() -> new RuntimeException("Publisher not found")));

        Set<UUID> authorsIDs = new HashSet<>(bookRequestDto.authorsIds());
        List<Author> authorList = authorRepository.findAllById(authorsIDs);
        if (authorsIDs.size() != authorList.size()) {
            throw new EntityNotFoundException("One or more authors not found");
        }
        book.setAuthors(new HashSet<>(authorList));

        Review review = new Review();
        review.setComment(bookRequestDto.reviewComment());
        review.setBook(book);
        book.setReview(review);

        return bookRepository.save(book);
        }
    }

