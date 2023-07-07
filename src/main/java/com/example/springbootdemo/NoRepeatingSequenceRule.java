package com.example.springbootdemo;

public class NoRepeatingSequenceRule implements PasswordValidationRule {

  @Override
  public boolean isValid(String password) {
    return !password.matches(".*(\\w)\\1.*");
  }
}
