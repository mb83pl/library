package com.library.webapp.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String isbn;

    @OneToMany(mappedBy = "book")
    private List<Rental> rentalSet = new ArrayList<>();

    public Book(String title, String description, String isbn) {
        this.title = title;
        this.description = description;
        this.isbn = isbn;
    }

    public Book(Long id, String title, String description, String isbn) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isbn = isbn;
    }

    public Book() {
    }
}
