package com.example.springbootdemo;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public PasswordValidationRule lowercaseAndDigitRule() {
    return new LowercaseAndDigitRule();
  }

  @Bean
  public PasswordValidationRule lengthRule() {
    return new LengthRule();
  }

  @Bean
  public PasswordValidationRule noRepeatingSequenceRule() {
    return new NoRepeatingSequenceRule();
  }

  @Bean
  public PasswordValidationService passwordValidationService(List<PasswordValidationRule> rules) {
    return new PasswordValidationService(rules);
  }
}

