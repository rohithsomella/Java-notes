package com.boot.project.aop;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.boot.project.exception.DuplicateBookException;
import com.boot.project.model.Book;

@ControllerAdvice
public class BookControllerAdvice {

	@ExceptionHandler(value = DuplicateBookException.class)
	public String duplicateBookExceptionHandling(DuplicateBookException exception, Model model)
	{
		/*
		 * this method is used to print the exception message by giving the alredy existed book by
		 * the same isbn from the array or database
		 * book info comes from the getBook method from exception class.
		 * and this page return the error page or we say exception page.
		 */
		Book book = exception.getBook();
		model.addAttribute("book",book);
		model.addAttribute("message","Duplicate Book Exception...");
		
		return "error-page";
	}
}
