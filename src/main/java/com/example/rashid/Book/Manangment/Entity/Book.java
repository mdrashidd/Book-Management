package com.example.rashid.Book.Manangment.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String title;

    @NotNull
    private LocalDateTime publishedOn;

    @OneToOne(mappedBy = "book_id")
    private Author author;

}
