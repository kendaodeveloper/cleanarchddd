package org.example.infraestructure.category;

import org.example.domain.category.Category;
import org.example.domain.category.CategoryID;
import org.example.domain.category.CategorySearchQuery;
import org.example.domain.pagination.Pagination;
import org.example.infraestructure.category.persistence.CategoryRepository;
import org.example.infraestructure.category.persistence.CategoryTable;
import org.example.interfaceadapter.category.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryGateway implements
    FindCategoryByIdGateway,
    FindCategoryByFilterGateway,
    CreateCategoryGateway,
    UpdateCategoryByIdGateway,
    DeleteCategoryByIdGateway {
  private final CategoryRepository repository;

  public CategoryGateway(final CategoryRepository repository) {
    this.repository = repository;
  }

  @Override
  public Optional<Category> findById(CategoryID id) {
    return Optional.empty();
  }

  @Override
  public Pagination<Category> findByFilter(CategorySearchQuery query) {
    return null;
  }

  @Override
  public Category create(Category category) {
    return this.repository.save(CategoryTable.from(category)).toAggregate();
  }

  @Override
  public Category updateById(CategoryID id, Category category) {
    return null;
  }
  @Override
  public void deleteById(CategoryID id) {

  }
}
