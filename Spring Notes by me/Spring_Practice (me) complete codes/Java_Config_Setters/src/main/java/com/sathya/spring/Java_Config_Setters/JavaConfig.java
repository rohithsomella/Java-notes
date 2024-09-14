package com.sathya.spring.Java_Config_Setters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

	@Bean
	public Car car()
	{
		Car car = new Car();
		car.setSpeed(120);
		car.setBrand("ducatti");
		return car;
	}
}