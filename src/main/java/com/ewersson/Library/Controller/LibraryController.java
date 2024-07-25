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

    // Create a library
    @PostMapping("/post")
    public Library createLibrary(@RequestBody Library library) {
        return libraryService.saveLibrary(library);
    }

    // Shows the entities present in the Library; Users and Books
    @GetMapping("/entities/{id}")
    public ResponseEntity<Library> getLibraryById(@PathVariable Integer id) {
        return libraryService.getLibraryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Show the books present in the Library
    @GetMapping("/{libraryId}/books")
    public ResponseEntity<Set<Books>> getBooksInLibrary(@PathVariable Integer libraryId) {
        Set<Books> books = libraryService.getBooksInLibrary(libraryId);
        return ResponseEntity.ok(books);
    }

    // Add books to the library
    @PostMapping("/{libraryId}/books/{bookId}")
    public void addBookToLibrary(@PathVariable Integer libraryId, @PathVariable Integer bookId) {
        libraryService.addBookToLibrary(libraryId, bookId);
    }

    // Add users to the library
    @PostMapping("/{libraryId}/users/{userId}")
    public void addUserToLibrary(@PathVariable Integer libraryId, @PathVariable Integer userId) {
        libraryService.addUserToLibrary(libraryId, userId);
    }

    // Updates information about books present in the library
    @PutMapping("/{libraryId}/books")
    public void updateBookInLibrary(@PathVariable Integer libraryId, @RequestBody Books book) {
        libraryService.updateBookInLibrary(libraryId, book);
    }

    // Updates information about users present in the library
    @PutMapping("/{libraryId}/users")
    public void updateUserInLibrary(@PathVariable Integer libraryId, @RequestBody User user) {
        libraryService.updateUserInLibrary(libraryId, user);
    }

    // Deletes books from the library
    @DeleteMapping("/{libraryId}/books/{bookId}")
    public void deleteBookFromLibrary(@PathVariable Integer libraryId, @PathVariable Integer bookId) {
        libraryService.deleteBookFromLibrary(libraryId, bookId);
    }

    // Deletes users from the library
    @DeleteMapping("/{libraryId}/users/{userId}")
    public void deleteUserFromLibrary(@PathVariable Integer libraryId, @PathVariable Integer userId) {
        libraryService.deleteUserFromLibrary(libraryId, userId);
    }
}
