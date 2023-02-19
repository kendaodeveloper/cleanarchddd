package org.example.domain.exception;

import org.example.domain.validation.ValidationError;

import java.util.List;

public class DomainException extends NoStackTraceException {
  private final List<ValidationError> errors;

  private DomainException(final String message, final List<ValidationError> errors) {
    super(message);
    this.errors = errors;
  }

  public static DomainException with(final ValidationError error) {
    return new DomainException("one or more errors occurred", List.of(error));
  }

  public static DomainException with(final List<ValidationError> errors) {
    return new DomainException("one or more errors occurred", errors);
  }

  public List<ValidationError> getErrors() {
    return errors;
  }
}
