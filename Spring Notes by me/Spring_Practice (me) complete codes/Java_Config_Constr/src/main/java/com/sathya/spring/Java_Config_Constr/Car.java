package com.sathya.spring.Java_Config_Constr;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {

	
	private int speed;
	private String Brand;
	
	
	
	public Car(int speed, String brand) {
		super();
		this.speed = speed;
		Brand = brand;
	}



	@Override
	public String toString() {
		return "Car [speed=" + speed + ", Brand=" + Brand + "]";
	}



	public Car() {
		super();

	}



	@Override
	public void move() {

		System.out.println("[speed=" + speed + ", Brand=" + Brand + "]");
	}

}
