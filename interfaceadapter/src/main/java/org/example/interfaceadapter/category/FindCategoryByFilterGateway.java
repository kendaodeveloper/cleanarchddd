package org.example.interfaceadapter.category;

import org.example.domain.category.Category;
import org.example.domain.category.CategorySearchQuery;
import org.example.domain.pagination.Pagination;

public interface FindCategoryByFilterGateway {
  Pagination<Category> findByFilter(CategorySearchQuery query);
}
