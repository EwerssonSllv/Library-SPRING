package com.ewersson.Library.Controller;

import com.ewersson.Library.Model.Books.Books;
import com.ewersson.Library.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Books createBook(@RequestBody Books book) {
        return bookService.saveBook(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Books> getBookById(@PathVariable Integer id) {
        return bookService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

