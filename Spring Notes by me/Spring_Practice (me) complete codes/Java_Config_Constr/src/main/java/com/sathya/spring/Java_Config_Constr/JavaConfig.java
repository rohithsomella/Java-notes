package com.sathya.spring.Java_Config_Constr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

	@Bean
	public Car car()
	{
		Car car = new Car(190,"Bugatti");
		return car;
	}
}
