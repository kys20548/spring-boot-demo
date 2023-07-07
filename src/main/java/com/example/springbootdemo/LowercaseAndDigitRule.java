package com.example.springbootdemo;

public class LowercaseAndDigitRule implements PasswordValidationRule {

  @Override
  public boolean isValid(String password) {
    return password.matches("^(?=.*[a-z])(?=.*\\d)[a-z\\d]+$");
  }
}
