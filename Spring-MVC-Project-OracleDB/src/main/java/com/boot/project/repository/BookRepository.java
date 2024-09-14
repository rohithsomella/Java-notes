package com.boot.project.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.boot.project.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn);
}
