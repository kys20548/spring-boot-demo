package com.example.springbootdemo;

import java.util.List;

public class PasswordValidationService {
  private final List<PasswordValidationRule> rules;

  public PasswordValidationService(List<PasswordValidationRule> rules) {
    this.rules = rules;
  }

  public boolean isValidPassword(String password) {
    for (PasswordValidationRule rule : rules) {
      if (!rule.isValid(password)) {
        return false;
      }
    }
    return true;
  }
}
