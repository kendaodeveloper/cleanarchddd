package org.example.domain.category.gateway;

import org.example.domain.category.Category;
import org.example.domain.category.CategoryID;

public interface UpdateCategoryByIdGateway {
  Category updateById(CategoryID id, Category category);
}
