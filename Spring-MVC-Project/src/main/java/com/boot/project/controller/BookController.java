package com.boot.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boot.project.exception.DuplicateBookException;
import com.boot.project.model.Book;
import com.boot.project.service.BookService;
import com.oracle.wls.shaded.org.apache.xalan.lib.Redirect;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/books") // all the methods comes under this url (start with this url.)
public class BookController {
	
	@Autowired //creating an object of service layer to call all the method in controller layer
	BookService bookService;
	
	@GetMapping("")
	public String landingPage()
	{
		return "landing";
	}
	@GetMapping("/viewbooks")
	public String getAllBooks(Model model)
	{
		// read the books and send the books to view layer using model object
		/*
		 * Model has model addAttributes which takes the both key, value pair
		 * this method used to get all the books from the array including both pre-entered
		 * and the values entered through web page. 
		 */
		List<Book> books= bookService.getBooks();
		model.addAttribute("books",books);
		
		/*
		 * this above books obj used to store the books information which comes from web page
		 * model obj useed to store the obj to display on the web page in table.
		 * and this model returns a web page (view-books.jsp file)
		 * this link end point is viewbooks---> /books/viewbooks
		 */
		
		return "view-books";
	}
	
	@GetMapping("/addbook")
	public String addBookPage()
	{
		/*
		 * this method will returns the web page to add new book into array (add-book.jsp file)
		 * this page link endpoint is addbook ---> /books/addbook
		 */
		return "add-book";
	}
	
	@PostMapping("/savebook")
	public String saveBook(@Valid @ModelAttribute Book book, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) throws DuplicateBookException
	{
		/*
		 * this method will add validation to the variables to store in given conditions with @valid annot
		 * method will save the errors in bindingResult obj to check with if condition.
		 * errors comes with the invalid entry by validation annot
		 * and it throws the DuplicateBookException for isbn duplication.
		 */
		
			if(bindingResult.hasErrors())
			{
				/*
				 * if invalid entry happens then bindigResult obj will store those errors
				 * to give the message acording to the validation of each variable
				 * and this condition return the book info save page (add-book.jsp file)
				 */
				model.addAttribute("error",bindingResult);
				return "add-book";
			}
		
			boolean status = bookService.saveBookData(book);
		
			if(status) {
				redirectAttributes.addFlashAttribute("savemessage", true);
				/*
				 * status variable stores the boolean value true or false
				 * which is the return value of saveBookData method from service layer
				 * if true then save message will get printed on viewbook page
				 * message is in jsp file with savemessage variable.
				 */
			}
		// this method returns to the view book page after performing its operation 
			return "redirect:/books/viewbooks";
		
	}
	
	@GetMapping("/delete/{isbn}")
	public String deleteBook(@PathVariable String isbn, RedirectAttributes redirectAttributes)
	{
		/*
		 * this method is used for delete button to delete the book by using service layer
		 * on the basis of isbn value.
		 */
		boolean status = bookService.deleteBookData(isbn);
		if(status)
		{	// same as above code status is true then delete message is printed on the screen viewbook page
			redirectAttributes.addFlashAttribute("deleteMeassage",true);
		}
		return "redirect:/books/viewbooks";
	}
	
	@GetMapping("/edit/{isbn}")
	public String editBook(@PathVariable String isbn, Model model) {
		/*
		 * based on isbn number book info can be updated in new page called editbook
		 * looks as same as addbook page with button name diff and no chance to add isbn again
		 * model is used to call the saved book obj
		 * this method will returns the editbook page.
		 */
	    Book book = bookService.editBookData(isbn);
	    // from the service layer this method brings the book obj
	    //model will print the book info in text boxes using jsp file.
	    model.addAttribute("book", book);
	    return "edit-book";  // 
	}

	@PostMapping("/editsavebook")
	public String saveEditedBook(@ModelAttribute Book editbook, RedirectAttributes redirectAttributes) {
	    Book book = bookService.updateBookData(editbook);
	    /*
	     * editbook variable stores the edited book obj from service layer logic
	     * if it is stored below condition accepted then it will print editmessage from jsp file
	     * on the viewbook page
	     * this method returns to viewbook page with redirect:.
	     */
	    if (book!=null) {
	        redirectAttributes.addFlashAttribute("editMessage", true);
	    }
	    return "redirect:/books/viewbooks";
	}
}
