package org.example.domain.category.gateway;

import org.example.domain.category.CategoryID;

public interface DeleteCategoryByIdGateway {
  void deleteById(CategoryID id);
}
