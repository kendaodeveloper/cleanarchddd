package org.example.infraestructure.configuration.usecase;

import org.example.application.category.create.CreateCategoryUseCase;
import org.example.application.category.create.DefaultCreateCategoryUseCase;
import org.example.infraestructure.category.CategoryGateway;
import org.example.interfaceadapter.category.FindCategoryByIdGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryUseCaseConfiguration {
  private final CategoryGateway categoryGateway;

  public CategoryUseCaseConfiguration(CategoryGateway categoryGateway) {
    this.categoryGateway = categoryGateway;
  }

  @Bean
  public CreateCategoryUseCase createCategoryUseCase() {
    return new DefaultCreateCategoryUseCase(categoryGateway);
  }
}
