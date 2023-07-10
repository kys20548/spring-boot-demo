package com.example.springbootdemo.service;

import com.example.springbootdemo.vo.ValidationResult;
import com.example.springbootdemo.dao.PasswordValidationRule;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PasswordValidationService {
  private final List<PasswordValidationRule> rules;

  public PasswordValidationService(List<PasswordValidationRule> rules) {
    this.rules = rules;
  }

  public ValidationResult isValidPassword(String password) {
    List<String> reasons = new ArrayList<>();
    for (PasswordValidationRule rule : rules) {
      if (!rule.isValid(password)) {
        reasons.add(rule.invalidMessage());
      }
    }

    if (reasons.isEmpty()) {
      return new ValidationResult(true, "Password is valid.");
    } else {
      String message = String.join(", ", reasons);
      return new ValidationResult(false, "Password is invalid. Reasons: " + message);
    }

  }
}
