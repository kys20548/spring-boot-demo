package com.example.springbootdemo.dao.impl;

import com.example.springbootdemo.dao.PasswordValidationRule;
import org.springframework.stereotype.Component;

@Component
public class LowercaseAndDigitRule implements PasswordValidationRule {

  public LowercaseAndDigitRule() {
  }

  @Override
  public boolean isValid(String password) {
    return password.matches("^(?=.*[a-z])(?=.*\\d)[a-z\\d]+$");
  }

  @Override
  public String invalidMessage() {
    return "Password must consist of lowercase letters and numerical digits only, with at least one of each";
  }
}
