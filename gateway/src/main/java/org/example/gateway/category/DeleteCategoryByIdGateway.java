package org.example.gateway.category;

import org.example.domain.category.CategoryID;

public interface DeleteCategoryByIdGateway {
  void deleteById(CategoryID id);
}
