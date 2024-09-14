package com.sathya.spring.XML_Config_Setters;

public class Car implements Vehicle {

	private int speed;
	private String brand;
	
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public void move() {
		System.out.println("Speed = "+getSpeed()+"  "+"Brand = "+getBrand());
	}

}
