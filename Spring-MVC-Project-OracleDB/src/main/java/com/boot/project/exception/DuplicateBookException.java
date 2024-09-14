package com.boot.project.exception;

import java.util.Optional;

import com.boot.project.model.Book;

public class DuplicateBookException extends Exception {

    private static final long serialVersionUID = 1L;

    public DuplicateBookException(String message) {
        super(message);
    }

    public DuplicateBookException(Optional<Book> existingBook) {
        super("A book with the same details already exists: " + formatBookDetails(existingBook.orElse(null)));
    }

    private static String formatBookDetails(Book book) {
        if (book != null) {
            return "ISBN: " + book.getIsbn() + ", Name: " + book.getName() + ", Author: " + book.getAuthor(); // Adjust fields as per your Book class
        }
        return "No book details provided";
    }
}
