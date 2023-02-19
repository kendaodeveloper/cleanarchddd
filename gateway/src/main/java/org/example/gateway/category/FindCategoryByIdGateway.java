package org.example.gateway.category;

import org.example.domain.category.Category;
import org.example.domain.category.CategoryID;

import java.util.Optional;

public interface FindCategoryByIdGateway {
  Optional<Category> findById(CategoryID id);
}
