package com.filipey.libraryapi.api.services;

import com.filipey.libraryapi.api.model.entity.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {

    Book save(Book any);
}
