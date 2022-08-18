package com.bridgelabz.addressbook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
public class AddressBookApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AddressBookApplication.class, args);
        System.out.println("Welcome To Address Book");
        log.info("Address Book Started in {} Environment",
                context.getEnvironment().getProperty("environment"));
    }
}
