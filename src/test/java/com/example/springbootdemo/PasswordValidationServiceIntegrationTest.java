package com.example.springbootdemo;
import com.example.springbootdemo.service.PasswordValidationService;
import com.example.springbootdemo.vo.ValidationResult;
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
    ValidationResult isValid = validationService.isValidPassword(password);
    Assertions.assertTrue(isValid.isSuccess());
  }

  @Test
  public void testInvalidPassword() {
    String password = "abc";
    ValidationResult isValid = validationService.isValidPassword(password);
    Assertions.assertFalse(isValid.isSuccess());
  }
}
