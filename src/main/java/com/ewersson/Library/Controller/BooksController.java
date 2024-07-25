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


    // Creates books
    @PostMapping("/post")
    public Books createBook(@RequestBody Books book) {
        return bookService.saveBook(book);
    }

    // Show a book
    @GetMapping("/get/{id}")
    public ResponseEntity<Books> getBookById(@PathVariable Integer id) {
        return bookService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Deletes a book
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Integer id) {
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }

    // Updates information about the book
    @PutMapping("/put/{id}")
    public ResponseEntity<Books> updateBook(@PathVariable Integer id, @RequestBody Books updatedBook) {
        Books book = bookService.updateBook(id, updatedBook);
        return ResponseEntity.ok(book);
    }

}
