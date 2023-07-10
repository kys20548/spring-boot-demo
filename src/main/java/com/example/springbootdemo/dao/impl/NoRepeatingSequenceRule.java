package com.example.springbootdemo.dao.impl;

import com.example.springbootdemo.dao.PasswordValidationRule;
import org.springframework.stereotype.Component;

@Component
public class NoRepeatingSequenceRule implements PasswordValidationRule {

  @Override
  public boolean isValid(String password) {
    return !password.matches(".*(\\w)\\1.*");
  }

  @Override
  public String invalidMessage() {
    return "Password must not contain any sequence of characters immediately followed by the same sequence.";
  }
}
