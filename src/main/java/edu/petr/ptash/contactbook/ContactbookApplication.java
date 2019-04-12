package edu.petr.ptash.contactbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

@SpringBootApplication
public class ContactbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactbookApplication.class, args);
    }

}
