package com.example.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner {

  @Autowired
  private PasswordValidationService validationService;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootDemoApplication.class, args);
  }

  @Override
  public void run(String... args) {
    if (args.length != 1) {
      System.out.println("Usage: PasswordValidationCLI <password>");
      return;
    }

    String password = args[0];
    boolean isValid = validationService.isValidPassword(password);

    if (isValid) {
      System.out.println("Password "+args[0]+" is valid.");
    } else {
      System.out.println("Password "+args[0]+" is invalid.");
    }

  }
}
