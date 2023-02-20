package org.example.application.category;

import org.example.domain.category.Category;
import org.example.domain.category.CategoryID;

public record CreateCategoryOutput(
    CategoryID id
) {
  public static CreateCategoryOutput from(final Category category) {
    return new CreateCategoryOutput(category.getId());
  }
}
