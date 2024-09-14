package com.boot.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.boot.project.exception.DuplicateBookException;
import com.boot.project.model.Book;

import jakarta.validation.Valid;

@Service
public class BookService {

	public static ArrayList<Book> books = new ArrayList<Book>();
	static
	{
		//initially adding few books to an array
		
		books.add(new Book("1001","Spring","Mr Ratan"));
		books.add(new Book("1002","Springboot","Mr Ram"));
		books.add(new Book("1003","Microservices","Mr Sathya"));
	}


	
	// used to get all the books from books array
	public List<Book> getBooks()
	{
		return books;
	}

	public boolean saveBookData(Book book) throws DuplicateBookException {
		// TODO Auto-generated method stub
		// last video code
		
		/*it is used to throw the exception if the duplicate isbn used to add as new book
		 *DuplicateBookException is an custom exception (class)
		 *Optional is used to for isPresent method.
		 *from books array isbn match with book isbn (entry from web)
		 * and stored in existingBook if match found.
		 */
		Optional<Book> existingBook = books.stream()
							.filter(b->b.getIsbn().equals(book.getIsbn()))
							.findFirst();
		if(existingBook.isPresent())
		{
			/*
			 * if existingBook has value it gives true as boolean value but stores book object
			 * and the method will takes us to Exception class layer...
			 */
			
			//throw new DuplicateBookException("ISBN is already there in the Table");
			throw new DuplicateBookException(existingBook);
		}
		
		/* if there is no duplicate book present in existingBook
		*then this method will add that new book
		*/
		return books.add(book);
	}

	public boolean deleteBookData(String isbn) {
		// TODO Auto-generated method stub
		/*
		 * this method is used to delete the existence book in the database or array.
		 * from books array match with isbn store that book in book obj
		 * then with the help of .remove() method that particular book will be removed
		 * from the books array.
		 */
		Book book = books.stream()
							.filter(b->b.getIsbn().equals(isbn))
							.findFirst()
							.get();
		return books.remove(book);	
	}

	public Book editBookData(String isbn) {
		// TODO Auto-generated method stub
		/*
		 * same like delete book obj stores the book obj with the match of isbn value
		 * and returns that book to display on the web page within their text boxes.
		 */
		Book book = books.stream()
							.filter(b->b.getIsbn().equals(isbn))
							.findFirst()
							.get();
		return book;
	}

	

	public Book updateBookData(Book editbook) {
		// TODO Auto-generated method stub
		/*
		 * this method is used to update the book information (name and author)
		 * edit book variable have the isbn value match with books array obj isbn value
		 * that book info stores in book obj
		 */
	    Book book=books.stream()
	    				.filter(b->b.getIsbn().equals(editbook.getIsbn()))
	    				.findFirst()
	    				.get();
	    if(book!=null)
	    {
	    	/*
	    	 * if match found and stored in book obj then its not null 
	    	 * then we can set new name and author with setter method by getting the values
	    	 * from the web browser which entered in text boxes.
	    	 */
	    	book.setName(editbook.getName());
	    	book.setAuthor(editbook.getAuthor());
	    }
	    // and this method will return the book with updated values.
	    return book;
	}



	


	
}
