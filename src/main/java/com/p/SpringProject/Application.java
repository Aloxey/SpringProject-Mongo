package com.p.SpringProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application{

    //  Starts the application
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}