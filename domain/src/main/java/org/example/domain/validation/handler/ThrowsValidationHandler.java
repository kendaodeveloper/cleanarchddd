package org.example.domain.validation.handler;

import org.example.domain.exception.DomainException;
import org.example.domain.validation.ValidationError;
import org.example.domain.validation.ValidationHandler;

import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {
  @Override
  public ValidationHandler append(final ValidationError error) {
    throw DomainException.with(List.of(error));
  }

  @Override
  public ValidationHandler append(final ValidationHandler handler) {
    throw DomainException.with(handler.getErrors());
  }

  @Override
  public ValidationHandler validate(Validation validation) {
    try {
      validation.validate();
    } catch (final Exception exception) {
      throw DomainException.with(List.of(new ValidationError(exception.getMessage())));
    }

    return this;
  }

  @Override
  public List<ValidationError> getErrors() {
    return List.of();
  }
}
