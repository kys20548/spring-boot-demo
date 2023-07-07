package com.example.springbootdemo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PasswordValidationServiceIntegrationTest {
  @Autowired
  private PasswordValidationService validationService;

  @Test
  public void testValidPassword() {
    String password = "abc123";
    boolean isValid = validationService.isValidPassword(password);
    Assertions.assertTrue(isValid);
  }

  @Test
  public void testInvalidPassword() {
    String password = "abc";
    boolean isValid = validationService.isValidPassword(password);
    Assertions.assertFalse(isValid);
  }
}
