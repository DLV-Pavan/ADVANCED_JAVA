package com.codegnan.spring_demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring.xml");

        HelloSpring obj = context.getBean(
                "helloSpring", HelloSpring.class);

        obj.display();
    }
}