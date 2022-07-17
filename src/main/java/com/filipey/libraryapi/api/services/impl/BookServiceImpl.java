package com.filipey.libraryapi.api.services.impl;

import com.filipey.libraryapi.api.model.entity.Book;
import com.filipey.libraryapi.api.model.repositories.BookRepository;
import com.filipey.libraryapi.api.services.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }
}
