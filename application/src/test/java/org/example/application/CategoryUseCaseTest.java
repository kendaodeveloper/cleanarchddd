package org.example.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryUseCaseTest {
  @Test
  public void createUseCase() {
    Assertions.assertNotNull(new CategoryUseCase());
  }
}
