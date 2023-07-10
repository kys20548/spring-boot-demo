package com.example.springbootdemo.dao.impl;


import com.example.springbootdemo.dao.PasswordValidationRule;
import org.springframework.stereotype.Component;

@Component
public class LengthRule implements PasswordValidationRule {

  final static private int MIN_LENGTH = 5;
  final static private int MAX_LENGTH = 12;

  @Override
  public boolean isValid(String password) {
    return password.length() >= MIN_LENGTH && password.length() <= MAX_LENGTH;
  }

  @Override
  public String invalidMessage() {
    return "Password length must be between " + MIN_LENGTH + " and " + MAX_LENGTH + " characters.";

  }
}
