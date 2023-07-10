package com.example.springbootdemo;

import com.example.springbootdemo.service.PasswordValidationService;
import com.example.springbootdemo.vo.ValidationResult;
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
      System.out.println("Please provide a password as a command line argument.");
      return;
    }

    String password = args[0];
    ValidationResult result = validationService.isValidPassword(password);

    System.out.println(result.getMessage());

  }
}
