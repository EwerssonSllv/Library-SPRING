package com.ewersson.Library.Service;

import com.ewersson.Library.Model.Books.Books;
import com.ewersson.Library.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Books saveBook(Books book) {
        return bookRepository.save(book);
    }

    public Optional<Books> getBookById(Integer id) {
        return bookRepository.findById(id);
    }
}

