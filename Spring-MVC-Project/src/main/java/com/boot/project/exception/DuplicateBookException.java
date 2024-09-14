package com.boot.project.exception;

import java.util.Optional;

import com.boot.project.model.Book;

public class DuplicateBookException extends Exception {

	Book book; //declared an obj.
	
	public DuplicateBookException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}

	public DuplicateBookException(Optional<Book> existingBook) {
		// TODO Auto-generated constructor stub
	    book = existingBook.get(); // if value is present gives the value else throws exception

	}
	
	public Book getBook() {
		/*
		 * this method is used to return the book info which already there in the array
		 * with the same isbn. used to display on the exception page 
		 */
		return book;
	}
}
