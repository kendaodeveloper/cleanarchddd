package org.example.domain.validation;

import java.util.List;

public interface ValidationHandler {
  ValidationHandler append(ValidationError error);

  ValidationHandler append(ValidationHandler handler);

  ValidationHandler validate(Validation validation);

  List<ValidationError> getErrors();

  default boolean hasError() {
    return getErrors() != null && !getErrors().isEmpty();
  }

  interface Validation {
    void validate();
  }
}
