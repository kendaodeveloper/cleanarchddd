package org.example.application.category.create;

import org.example.domain.category.Category;
import org.example.domain.validation.handler.ThrowsValidationHandler;
import org.example.interfaceadapter.category.CreateCategoryGateway;

import java.util.Objects;

public class DefaultCreateCategoryUseCase extends CreateCategoryUseCase {
  private final CreateCategoryGateway createCategoryGateway;

  public DefaultCreateCategoryUseCase(final CreateCategoryGateway createCategoryGateway) {
    this.createCategoryGateway = Objects.requireNonNull(createCategoryGateway);
  }

  @Override
  public CreateCategoryOutput execute(final CreateCategoryInput input) {
    final var category = Category.newCategory(input.name(), input.description(), input.isActive());
    category.validate(new ThrowsValidationHandler());
    return CreateCategoryOutput.from(this.createCategoryGateway.create(category));
  }
}
