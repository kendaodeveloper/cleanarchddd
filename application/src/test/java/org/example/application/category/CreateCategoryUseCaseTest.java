package org.example.application.category;

import org.example.application.category.create.CreateCategoryInput;
import org.example.application.category.create.DefaultCreateCategoryUseCase;
import org.example.domain.category.Category;
import org.example.domain.category.gateway.CreateCategoryGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CreateCategoryUseCaseTest {
  @Mock
  private CreateCategoryGateway createCategoryGateway;
  @InjectMocks
  private DefaultCreateCategoryUseCase useCase;

  @Test
  public void givenAValidCommand_whenCallsCreateCategory_shouldReturnCategoryId() {
    final var expectedName = "Filmes";
    final var expectedDescription = "A categoria mais assistida";
    final var expectedIsActive = true;
    final var newCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);

    Mockito.when(this.createCategoryGateway.create(Mockito.any())).thenReturn(newCategory);

    final var input = CreateCategoryInput.with(expectedName, expectedDescription, expectedIsActive);
    final var output = this.useCase.execute(input);

    Assertions.assertNotNull(output);
    Assertions.assertEquals(output.id(), newCategory.getId());
  }
}
