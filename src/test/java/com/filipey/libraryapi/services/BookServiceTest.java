package com.filipey.libraryapi.services;

import com.filipey.libraryapi.api.model.entity.Book;
import com.filipey.libraryapi.api.model.repositories.BookRepository;
import com.filipey.libraryapi.api.services.BookService;
import com.filipey.libraryapi.api.services.impl.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class BookServiceTest {

    BookService service;

    @MockBean
    BookRepository repository;

    @BeforeEach
    public void setUp() {
        this.service = new BookServiceImpl(repository);
    }

    @Test
    @DisplayName("Should save a book in the database")
    void saveBookTest() {
        Book book = Book.builder().isbn("123").author("John Doe").title("My Book").build();
        Book returnedBook = Book.builder().id(1L).isbn(book.getIsbn()).author(book.getAuthor()).title(book.getTitle()).build();
        Mockito.when(repository.save(book)).thenReturn(returnedBook);

        Book savedBook = service.save(book);

        assertThat(savedBook.getId()).isNotNull();
        assertThat(savedBook.getIsbn()).isEqualTo(book.getIsbn());
        assertThat(savedBook.getAuthor()).isEqualTo(book.getAuthor());
        assertThat(savedBook.getTitle()).isEqualTo(book.getTitle());
    }
}
