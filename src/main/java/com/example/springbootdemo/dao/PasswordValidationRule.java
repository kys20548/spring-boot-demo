package com.example.springbootdemo.dao;

public interface PasswordValidationRule {

  boolean isValid(String password);

  String invalidMessage();

}
