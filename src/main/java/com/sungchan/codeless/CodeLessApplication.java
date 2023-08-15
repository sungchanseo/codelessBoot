package com.sungchan.codeless;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class CodeLessApplication implements CommandLineRunner {

    @Autowired
    EntityManagerFactory emf;

    public static void main(String[] args) {

      //  SpringApplication.run(CodeLessApplication.class, args);

        SpringApplication app = new SpringApplication(CodeLessApplication.class);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
