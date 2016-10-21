package com.pzj.salesSKU.test.order;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml");
        context.start();  
        System.in.read();
    }
}
