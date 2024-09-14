package com.sathya.spring.XML_Config_Constr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main(String[] args)
    {
    	 ApplicationContext context = new ClassPathXmlApplicationContext("Config.xml");
    	    Car c = context.getBean("carr",Car.class);
    	    c.move();
    }
}
