package com.ewersson.Library.Model.Library;

import com.ewersson.Library.Model.Books.Books;
import com.ewersson.Library.Model.User.User;
import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

@Entity
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    @MapKey(name = "id")
    private Map<Integer, Books> booksSet = new HashMap<>();

    @OneToMany
    @MapKey(name = "id")
    private Map<Integer, User> userSet = new HashMap<>();

    public Library() {}

    public void addBook(Books book) {
        booksSet.put(book.getId(), book);
    }

    public Books getBookById(Integer id) {
        return booksSet.get(id);
    }

    public void addUser(User user) {
        userSet.put(user.getId(), user);
    }

    public User getUserById(Integer id) {
        return userSet.get(id);
    }

    public Map<Integer, Books> getBooksSet() {
        return booksSet;
    }

    public Map<Integer, User> getUserSet() {
        return userSet;
    }


}
