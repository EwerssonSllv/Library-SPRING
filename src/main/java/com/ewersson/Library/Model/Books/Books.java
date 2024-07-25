package com.ewersson.Library.Model.Books;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = Books.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Books {

    public static final String TABLE_NAME = "Books";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "title", nullable = false)
    @NotNull
    @NotBlank
    @Size(min = 1)
    private String title;

    @Column(name = "author", nullable = false)
    @NotNull
    @NotBlank
    @Size(min = 1)
    private String author;

    @Column(name = "releaseYear", nullable = false)
    @NotNull
    @NotBlank
    @Size(min = 1)
    private String releaseYear;

    public Books(String title, String author, String releaseYear) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Book: "
                + "id: " + id
                + ", title: " + title
                + ", author: " + author
                + ", releaseYear: " + releaseYear;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull @NotBlank @Size(min = 1) String getTitle() {
        return title;
    }

    public void setTitle(@NotNull @NotBlank @Size(min = 1) String title) {
        this.title = title;
    }

    public @NotNull @NotBlank @Size(min = 1) String getAuthor() {
        return author;
    }

    public void setAuthor(@NotNull @NotBlank @Size(min = 1) String author) {
        this.author = author;
    }

    public @NotNull @NotBlank @Size(min = 1) String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(@NotNull @NotBlank @Size(min = 1) String releaseYear) {
        this.releaseYear = releaseYear;
    }
}
