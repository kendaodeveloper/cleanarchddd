package org.example.infraestructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StartApplicationTest {
  @Test
  public void testMainMethod() {
    Assertions.assertNotNull(new StartApplication());
    StartApplication.main(new String[]{});
  }
}
