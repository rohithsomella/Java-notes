package com.boot.project.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	/*class level annotation used to reduce the boiler code 
	 * to string, setter, getters, constructures etc..
	 * 
	 * 
	 * validation will comes below text box in webpage if given value is not valid.
	 * validations we can write with the help of spring-validation dependency.
	 * all the given annotations above the variable are from spring-validation dependency
	 */

	@NotNull(message= "ISBN cannot be null") 
	private String isbn;
	
	@NotBlank(message = "Book Name Required")
	private String name;
	
	@NotBlank(message = "Book Author Required")
	@Size(min = 3, max = 30, message = "Author name between 5 to 30 charecters")
	private String author;
}
