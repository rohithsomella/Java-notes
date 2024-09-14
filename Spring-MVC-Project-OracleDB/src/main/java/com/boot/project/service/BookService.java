package com.boot.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.project.exception.DuplicateBookException;
import com.boot.project.model.Book;
import com.boot.project.repository.BookRepository;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Get all books from the database
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    // Save book data to the database, throw exception if duplicate ISBN
    public void saveBookData(Book book) throws DuplicateBookException {
        Optional<Book> existingBook = bookRepository.findByIsbn(book.getIsbn());
        if (existingBook.isPresent()) {
            throw new DuplicateBookException(existingBook);
        }
        bookRepository.save(book);
    }

    // Delete a book from the database
    public void deleteBookData(Long id) {
        bookRepository.deleteById(id);
    }

    // Get book data for editing
    public Book editBookData(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    // Update book data in the database
    public void updateBookData(Book book) {
        Optional<Book> existingBook = bookRepository.findByIsbn(book.getIsbn());
        if (existingBook.isPresent()) {
            Book updatedBook = existingBook.get();
            updatedBook.setName(book.getName());
            updatedBook.setAuthor(book.getAuthor());
            bookRepository.save(updatedBook);
        }
    }
}
