package com.example.rashid.Book.Manangment.Repository;

import com.example.rashid.Book.Manangment.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
