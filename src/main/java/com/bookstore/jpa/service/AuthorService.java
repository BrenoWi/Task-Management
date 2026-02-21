package com.bookstore.jpa.service;

import com.bookstore.jpa.entity.Author;
import com.bookstore.jpa.entity.dto.AuthorRequestDto;
import com.bookstore.jpa.entity.dto.AuthorResponseDto;
import com.bookstore.jpa.mapper.AuthorMapper;
import com.bookstore.jpa.repository.IAuthorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final IAuthorRepository authorRepository;

    public AuthorService(IAuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorResponseDto saveAuthor(AuthorRequestDto authorRequestDto){
        if(authorRepository.existsByName(authorRequestDto.name())){
            throw new RuntimeException("Author already exists in database.");
        }
        Author author = new Author();
        author.setName(authorRequestDto.name());

        return AuthorMapper.toDto(authorRepository.save(author));
    }

    public AuthorResponseDto findAuthorById(Long id){
        return AuthorMapper.toDto(authorRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Author not found.")));
    }

    public void deleteAuthorById(Long id){
        Author author = authorRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Autor not found."));
        if(!author.getBooks().isEmpty()){
            throw new IllegalStateException("Author has books, can't be deleted.");
        }
        authorRepository.delete(author);
    }
}
