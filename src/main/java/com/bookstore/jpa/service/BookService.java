package com.bookstore.jpa.service;

import com.bookstore.jpa.entity.Author;
import com.bookstore.jpa.entity.Book;
import com.bookstore.jpa.entity.Publisher;
import com.bookstore.jpa.entity.Review;
import com.bookstore.jpa.entity.dto.BookRequestDto;
import com.bookstore.jpa.entity.dto.BookResponseDto;
import com.bookstore.jpa.mapper.BookMapper;
import com.bookstore.jpa.repository.IAuthorRepository;
import com.bookstore.jpa.repository.IBookRepository;
import com.bookstore.jpa.repository.IPublisherRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public BookResponseDto saveBook(BookRequestDto bookRequestDto){
        if (bookRepository.existsByTitle(bookRequestDto.title())){
            throw new RuntimeException("Book already exists in database.");
        }
        Book book = new Book();
        book.setTitle(bookRequestDto.title());
        Publisher publisher = publisherRepository.findByName(bookRequestDto.publisherName())
                .orElseThrow(() -> new EntityNotFoundException("Publisher nor found."));
        book.setPublisher(publisher);

        Set<Author> authors = new HashSet<>();
        for (String name: bookRequestDto.authors()){
            authors.add(authorRepository.findByName(name)
                    .orElseThrow(() -> new EntityNotFoundException("Author not found.")));

        }
        book.setAuthors(authors);

        Review review = new Review();
        review.setComment(bookRequestDto.reviewComment());
        review.setBook(book);
        book.setReview(review);

        return BookMapper.toDto(bookRepository.save(book));
    }

    public BookResponseDto getBookById(Long id){
        return BookMapper.toDto(bookRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Book not found.")));
    }
}



