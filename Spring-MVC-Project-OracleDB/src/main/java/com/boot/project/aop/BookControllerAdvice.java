package com.boot.project.aop;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class BookControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return new ModelAndView("error");
    }

    // Add more specific exception handlers if needed
}
