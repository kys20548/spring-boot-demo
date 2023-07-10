package com.example.springbootdemo;

import com.example.springbootdemo.dao.impl.LengthRule;
import com.example.springbootdemo.dao.impl.LowercaseAndDigitRule;
import com.example.springbootdemo.dao.impl.NoRepeatingSequenceRule;
import com.example.springbootdemo.service.PasswordValidationService;
import com.example.springbootdemo.vo.ValidationResult;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PasswordValidationServiceTest2 {
  private PasswordValidationService validationService;

  @BeforeEach
  public void setup() {
    validationService = new PasswordValidationService(Arrays.asList(
        new LowercaseAndDigitRule(),
        new LengthRule(),
        new NoRepeatingSequenceRule()
    ));
  }

  @Nested
  @DisplayName("Positive Testing")
  class PositiveTesting {
    @ParameterizedTest
    @CsvSource({
        "abc123",
        "a1b2c3",
        "pasword123"
    })
    public void testValidPasswords(String password) {
      ValidationResult result = validationService.isValidPassword(password);
      Assertions.assertTrue(result.isSuccess());
    }
  }

  @Nested
  @DisplayName("Negative Testing")
  class NegativeTesting {
    @ParameterizedTest
    @CsvSource({
        "abc",
        "123",
        "abc",
        "password",
        "ABC123",
        "aBcDeF"
    })
    public void testInvalidPasswords(String password) {
       ValidationResult result = validationService.isValidPassword(password);
      Assertions.assertFalse(result.isSuccess());
    }
  }

  @Nested
  @DisplayName("Boundary Testing")
  class BoundaryTesting {
    @ParameterizedTest
    @CsvSource({
        "abc1",
        "abc1234567890",
        "ABC123",
        "ABCDEFGHIJKL"
    })
    public void testBoundaryPasswords(String password) {
       ValidationResult result = validationService.isValidPassword(password);
      Assertions.assertFalse(result.isSuccess());
    }

    @ParameterizedTest
    @CsvSource({
        "abc123",
        "abc1234",
        "abc12345",
        "abc123456",
        "abc1234567",
        "abc12345678",
        "abc123456789",
    })
    public void testValidBoundaryPasswords(String password) {
      ValidationResult result = validationService.isValidPassword(password);
      Assertions.assertTrue(result.isSuccess());
    }
  }

  @Nested
  @DisplayName("Special Character Testing")
  class SpecialCharacterTesting {
    @ParameterizedTest
    @CsvSource({
        "abc@123",
        "abc#123",
        "abc$123",
        "abc%123",
        "abc&123",
        "abc*123"
    })
    public void testSpecialCharacterPasswords(String password) {
       ValidationResult result = validationService.isValidPassword(password);
      Assertions.assertFalse(result.isSuccess());
    }
  }

  @Nested
  @DisplayName("Repeated Character Testing")
  class RepeatedCharacterTesting {
    @ParameterizedTest
    @CsvSource({
        "abcc123",
        "abc1123",
        "abc1233",
        "aaabbb123",
        "abccba123"
    })
    public void testRepeatedCharacterPasswords(String password) {
       ValidationResult result = validationService.isValidPassword(password);
      Assertions.assertFalse(result.isSuccess());
    }
  }
}
