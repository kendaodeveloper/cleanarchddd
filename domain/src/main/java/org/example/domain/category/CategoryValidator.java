package org.example.domain.category;

import org.example.domain.validation.ValidationError;
import org.example.domain.validation.ValidationHandler;
import org.example.domain.validation.Validator;

public class CategoryValidator extends Validator {
  public static final String NAME_SHOULD_NOT_BE_NULL = "'name' should not be null";
  public static final String NAME_SHOULD_NOT_BE_EMPTY = "'name' should not be empty";
  public static final String NAME_CONTAINS_INVALID_SIZE = "'name' must be between 3 and 255 characters";
  public static final int NAME_MAX_LENGTH = 255;
  public static final int NAME_MIN_LENGTH = 3;

  private final Category category;

  public CategoryValidator(final Category category, final ValidationHandler handler) {
    super(handler);
    this.category = category;
  }

  @Override
  public void validate() {
    checkNameConstraints();
  }

  private void checkNameConstraints() {
    final var name = this.category.getName();
    if (name == null) {
      this.validationHandler().append(new ValidationError(NAME_SHOULD_NOT_BE_NULL));
      return;
    }

    if (name.isBlank()) {
      this.validationHandler().append(new ValidationError(NAME_SHOULD_NOT_BE_EMPTY));
      return;
    }

    final var length = name.trim().length();
    if (length > NAME_MAX_LENGTH || length < NAME_MIN_LENGTH) {
      this.validationHandler().append(new ValidationError(NAME_CONTAINS_INVALID_SIZE));
    }
  }
}
