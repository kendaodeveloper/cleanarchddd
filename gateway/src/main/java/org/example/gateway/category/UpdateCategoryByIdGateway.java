package org.example.gateway.category;

import org.example.domain.category.Category;
import org.example.domain.category.CategoryID;

public interface UpdateCategoryByIdGateway {
  Category updateById(CategoryID id, Category category);
}
