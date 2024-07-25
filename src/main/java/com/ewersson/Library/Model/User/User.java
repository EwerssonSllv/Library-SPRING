package com.ewersson.Library.Model.User;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= User.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    public static final String TABLE_NAME = "Users";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true)
    private Integer id;

    @Column(name="username", nullable = false, length = 100, unique=true)
    @Size(min = 3, max = 100)
    private String username;

    @Column(name = "password", length = 100, nullable = false)
    //@JsonProperty(access = Access.WRITE_ONLY)
    @Size(min = 1, max = 15)
    private String password;

    @ElementCollection
    private Set<Integer> collectionOfBooks = new HashSet<>();

    public User(String username,String password) {
        this.username = username;
        this.password = password;
    }

    public void addBook(int bookId) {
        collectionOfBooks.add(bookId);
    }

    public void removeBook(int bookId) {
        collectionOfBooks.remove(bookId);
    }

    public Set<Integer> getCollection() {
        return collectionOfBooks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull @NotBlank @Size(min = 3, max = 100) String getUsername() {
        return username;
    }

    public void setUsername(@NotNull @NotBlank @Size(min = 3, max = 100) String username) {
        this.username = username;
    }

    public @NotBlank @Size(min = 8, max = 60) String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank @Size(min = 8, max = 60) String password) {
        this.password = password;
    }

    public Set<Integer> getPersonalcollection() {
        return collectionOfBooks;
    }

    public void setPersonalcollection(Set<Integer> personalcollection) {
        this.collectionOfBooks = personalcollection;
    }
}
