package com.bookstore.jpa.service;

import com.bookstore.jpa.entity.Author;
import com.bookstore.jpa.entity.dto.AuthorDto;
import com.bookstore.jpa.repository.IAuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final IAuthorRepository authorRepository;

    public AuthorService(IAuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author saveAuthor(AuthorDto authorDto){
        if(authorRepository.existsByName(authorDto.name())){
            throw new RuntimeException("Author already exists in database.");
        }
        Author author = new Author();
        author.setName(authorDto.name());

        return authorRepository.save(author);
    }
}
