package org.example.interfaceadapter.category;

import org.example.domain.category.Category;
import org.example.domain.category.CategoryID;

public interface UpdateCategoryByIdGateway {
  Category updateById(CategoryID id, Category category);
}
