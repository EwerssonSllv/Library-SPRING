package com.ewersson.Library.Service;

import com.ewersson.Library.Model.Books.Books;
import com.ewersson.Library.Model.Library.Library;
import com.ewersson.Library.Model.User.User;
import com.ewersson.Library.Repository.BookRepository;
import com.ewersson.Library.Repository.LibraryRepository;
import com.ewersson.Library.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    public Library saveLibrary(Library library) {
        return libraryRepository.save(library);
    }

    public Optional<Library> getLibraryById(Integer id) {
        return libraryRepository.findById(id);
    }

    public void addBookToLibrary(Integer libraryId, Integer bookId) {
        Library library = libraryRepository.findById(libraryId).orElseThrow(() -> new RuntimeException("Library not found"));
        Books book = bookRepository.findById(bookId).orElseThrow(() ->
                new RuntimeException("Book not found"));
        library.addBook(book);
        libraryRepository.save(library);
    }

    public void addUserToLibrary(Integer libraryId, Integer userId) {
        Library library = libraryRepository.findById(libraryId).orElseThrow(()
                -> new RuntimeException("Library not found"));
        User user = userRepository.findById(userId).orElseThrow(() ->
                new RuntimeException("User not found"));
        library.addUser(user);
        libraryRepository.save(library);
    }

    public Set<Books> getBooksInLibrary(Integer libraryId) {
        Library library = libraryRepository.findById(libraryId).orElseThrow(() ->
                new RuntimeException("Library not found"));
        return new HashSet<>(library.getBooksSet().values());
    }
}
