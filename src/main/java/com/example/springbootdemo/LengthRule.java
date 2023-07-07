package com.example.springbootdemo;


public class LengthRule implements PasswordValidationRule {

  @Override
  public boolean isValid(String password) {
    return password.length() >= 5 && password.length() <= 12;
  }
}
