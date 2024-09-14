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

import jakarta.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // Landing page to display all books
    @GetMapping
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "landing"; // Returns the landing page (landing.jsp or landing.html)
    }

    // View all books
    @GetMapping("/viewbooks")
    public String viewBooks(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "view-books"; // Returns the view-books page to display all books
    }

    // Show form to add a new book
    @GetMapping("/addbook")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book"; // Returns the add-book form page
    }

    @PostMapping("/savebook")
    public String saveBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult); // Add bindingResult to model for error display
            return "add-book"; // Returns the add-book form page if validation fails
        }

        try {
            bookService.saveBookData(book);
            redirectAttributes.addFlashAttribute("savemessage", true);
        } catch (DuplicateBookException e) {
            bindingResult.rejectValue("isbn", "error.book", "ISBN already exists.");
            model.addAttribute("error", bindingResult); // Add bindingResult to model for error display
            return "add-book"; // Returns the add-book form page with error message if ISBN already exists
        }

        return "redirect:/books/viewbooks"; // Redirects to view all books page after successful save
    }


    // Show form to edit a book
    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") Long id, Model model) {
        Book book = bookService.editBookData(id);
        if (book == null) {
            return "redirect:/books/viewbooks"; // Redirects to view all books if book with given id is not found
        }
        model.addAttribute("book", book);
        return "edit-book"; // Returns the edit-book form page
    }

    // Update book
    @PostMapping("/update")
    public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "edit-book"; // Returns the edit-book form page if validation fails
        }

        bookService.updateBookData(book);
        redirectAttributes.addFlashAttribute("successMessage", "Book updated successfully!");
        return "redirect:/books/viewbooks"; // Redirects to view all books page after successful update
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            bookService.deleteBookData(id);
            redirectAttributes.addFlashAttribute("deleteMessage", true);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to delete book. Please try again.");
        }
        return "redirect:/books/viewbooks";
    }

    
    @PostMapping("/editsavebook")
    public String saveEditedBook(@Valid @ModelAttribute("book") Book editedBook, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "edit-book"; // Return to edit form if there are validation errors
        }
        
        try {
            bookService.updateBookData(editedBook);
            redirectAttributes.addFlashAttribute("editMessage", true);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to update book. Please try again.");
        }
        
        return "redirect:/books/viewbooks";
    }

}

