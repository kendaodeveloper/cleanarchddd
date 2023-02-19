package org.example.gateway.category;

import org.example.domain.category.Category;
import org.example.domain.category.CategorySearchQuery;
import org.example.domain.pagination.Pagination;

public interface FindCategoriesByFilterGateway {
  Pagination<Category> findAll(CategorySearchQuery query);
}
