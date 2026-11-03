package com.employee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
	public static void main(String args[]) {
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		Employee emp=context.getBean(Employee.class);
		emp.display();
	}

}
