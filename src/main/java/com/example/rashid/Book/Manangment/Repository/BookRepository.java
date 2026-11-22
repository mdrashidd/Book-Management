package com.example.rashid.Book.Manangment.Repository;

import com.example.rashid.Book.Manangment.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {


    List<Book> findByAuthor(String author);

    Book findByTitle(String title);

    List<Book> findByPublishedOnAfter(LocalDateTime publishedAfter);
}
