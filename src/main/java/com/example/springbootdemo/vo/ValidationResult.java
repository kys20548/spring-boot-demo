package com.example.springbootdemo.vo;

public class ValidationResult {

  private boolean success;
  private String message;

  public ValidationResult(boolean success, String message) {
    this.success = success;
    this.message = message;
  }

  public boolean isSuccess() {
    return success;
  }

  public String getMessage() {
    return message;
  }
}

