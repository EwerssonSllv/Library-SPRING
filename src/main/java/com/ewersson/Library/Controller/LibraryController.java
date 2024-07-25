package com.ewersson.Library.Controller;

import com.ewersson.Library.Model.Books.Books;
import com.ewersson.Library.Model.Library.Library;
import com.ewersson.Library.Model.User.User;
import com.ewersson.Library.Service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping
    public Library createLibrary(@RequestBody Library library) {
        return libraryService.saveLibrary(library);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Library> getLibraryById(@PathVariable Integer id) {
        return libraryService.getLibraryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{libraryId}/books")
    public ResponseEntity<Set<Books>> getBooksInLibrary(@PathVariable Integer libraryId) {
        Set<Books> books = libraryService.getBooksInLibrary(libraryId);
        return ResponseEntity.ok(books);
    }

    @PostMapping("/{libraryId}/books/{bookId}")
    public void addBookToLibrary(@PathVariable Integer libraryId, @PathVariable Integer bookId) {
        libraryService.addBookToLibrary(libraryId, bookId);
    }

    @PostMapping("/{libraryId}/users/{userId}")
    public void addUserToLibrary(@PathVariable Integer libraryId, @PathVariable Integer userId) {
        libraryService.addUserToLibrary(libraryId, userId);
    }
}
