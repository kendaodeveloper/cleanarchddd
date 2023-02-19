package org.example.domain.category;

import org.example.domain.exception.DomainException;
import org.example.domain.validation.handler.ThrowsValidationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryTest {
  @Test
  public void givenAValidParams_whenCallNewCategory_thenInstantiateACategory() {
    final var expectedName = "Filmes";
    final var expectedDescription = "A categoria mais assistida";
    final var expectedIsActive = true;

    final var actualCategory =
        Category.newCategory(expectedName, expectedDescription, expectedIsActive);

    Assertions.assertNotNull(actualCategory);
    Assertions.assertNotNull(actualCategory.getId());
    Assertions.assertEquals(expectedName, actualCategory.getName());
    Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
    Assertions.assertEquals(expectedIsActive, actualCategory.isActive());
    Assertions.assertNotNull(actualCategory.getCreatedAt());
    Assertions.assertNotNull(actualCategory.getUpdatedAt());
    Assertions.assertNull(actualCategory.getDeletedAt());
  }

  @Test
  public void givenANullName_whenCallNewCategoryAndValidate_thenShouldReceiveError() {
    final String expectedName = null;
    final var expectedDescription = "A categoria mais assistida";
    final var expectedIsActive = true;

    final var exceptedErrorCount = 1;
    final var exceptedErrorMessage = CategoryValidator.NAME_SHOULD_NOT_BE_NULL;

    final var actualCategory =
        Category.newCategory(expectedName, expectedDescription, expectedIsActive);

    final var exception = Assertions.assertThrows(DomainException.class, () -> actualCategory.validate(new ThrowsValidationHandler()));

    Assertions.assertNotNull(exception);
    Assertions.assertNotNull(exception.getErrors());
    Assertions.assertEquals(exception.getErrors().size(), exceptedErrorCount);
    Assertions.assertEquals(exception.getErrors().get(0).message(), exceptedErrorMessage);
  }

  @Test
  public void givenAnEmptyName_whenCallNewCategoryAndValidate_thenShouldReceiveError() {
    final String expectedName = " ";
    final var expectedDescription = "A categoria mais assistida";
    final var expectedIsActive = true;

    final var exceptedErrorCount = 1;
    final var exceptedErrorMessage = CategoryValidator.NAME_SHOULD_NOT_BE_EMPTY;

    final var actualCategory =
        Category.newCategory(expectedName, expectedDescription, expectedIsActive);

    final var exception = Assertions.assertThrows(DomainException.class, () -> actualCategory.validate(new ThrowsValidationHandler()));

    Assertions.assertNotNull(exception);
    Assertions.assertNotNull(exception.getErrors());
    Assertions.assertEquals(exception.getErrors().size(), exceptedErrorCount);
    Assertions.assertEquals(exception.getErrors().get(0).message(), exceptedErrorMessage);
  }

  @Test
  public void givenANameLengthLessThan3_whenCallNewCategoryAndValidate_thenShouldReceiveError() {
    final String expectedName = " az ";
    final var expectedDescription = "A categoria mais assistida";
    final var expectedIsActive = true;

    final var exceptedErrorCount = 1;
    final var exceptedErrorMessage = CategoryValidator.NAME_CONTAINS_INVALID_SIZE;

    final var actualCategory =
        Category.newCategory(expectedName, expectedDescription, expectedIsActive);

    final var exception = Assertions.assertThrows(DomainException.class, () -> actualCategory.validate(new ThrowsValidationHandler()));

    Assertions.assertNotNull(exception);
    Assertions.assertNotNull(exception.getErrors());
    Assertions.assertEquals(exception.getErrors().size(), exceptedErrorCount);
    Assertions.assertEquals(exception.getErrors().get(0).message(), exceptedErrorMessage);
  }

  @Test
  public void givenANameLengthMoreThan255_whenCallNewCategoryAndValidate_thenShouldReceiveError() {
    final String expectedName = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus vehicula, nunc eu tempor rutrum, risus arcu auctor ex, tincidunt vulputate erat tortor in magna. Phasellus molestie tempus posuere. Morbi nec ipsum nec ligula pulvinar molestie eu nec urna. Aliquam aliquam, urna ac ullamcorper ultricies, ligula sapien viverra quam, ut faucibus.";
    final var expectedDescription = "A categoria mais assistida";
    final var expectedIsActive = true;

    final var exceptedErrorCount = 1;
    final var exceptedErrorMessage = CategoryValidator.NAME_CONTAINS_INVALID_SIZE;

    final var actualCategory =
        Category.newCategory(expectedName, expectedDescription, expectedIsActive);

    final var exception = Assertions.assertThrows(DomainException.class, () -> actualCategory.validate(new ThrowsValidationHandler()));

    Assertions.assertNotNull(exception);
    Assertions.assertNotNull(exception.getErrors());
    Assertions.assertEquals(exception.getErrors().size(), exceptedErrorCount);
    Assertions.assertEquals(exception.getErrors().get(0).message(), exceptedErrorMessage);
  }

  @Test
  public void givenANullDescription_whenCallNewCategoryAndValidate_thenInstantiateACategory() {
    final String expectedName = "Filmes";
    final String expectedDescription = null;
    final var expectedIsActive = true;

    final var actualCategory =
        Category.newCategory(expectedName, expectedDescription, expectedIsActive);

    Assertions.assertDoesNotThrow(() -> actualCategory.validate(new ThrowsValidationHandler()));

    Assertions.assertNotNull(actualCategory);
    Assertions.assertNotNull(actualCategory.getId());
    Assertions.assertEquals(expectedName, actualCategory.getName());
    Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
    Assertions.assertEquals(expectedIsActive, actualCategory.isActive());
    Assertions.assertNotNull(actualCategory.getCreatedAt());
    Assertions.assertNotNull(actualCategory.getUpdatedAt());
    Assertions.assertNull(actualCategory.getDeletedAt());
  }

  @Test
  public void givenAnEmptyDescription_whenCallNewCategoryAndValidate_thenInstantiateACategory() {
    final String expectedName = "Filmes";
    final var expectedDescription = "";
    final var expectedIsActive = true;

    final var actualCategory =
        Category.newCategory(expectedName, expectedDescription, expectedIsActive);

    Assertions.assertDoesNotThrow(() -> actualCategory.validate(new ThrowsValidationHandler()));

    Assertions.assertNotNull(actualCategory);
    Assertions.assertNotNull(actualCategory.getId());
    Assertions.assertEquals(expectedName, actualCategory.getName());
    Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
    Assertions.assertEquals(expectedIsActive, actualCategory.isActive());
    Assertions.assertNotNull(actualCategory.getCreatedAt());
    Assertions.assertNotNull(actualCategory.getUpdatedAt());
    Assertions.assertNull(actualCategory.getDeletedAt());
  }

  @Test
  public void givenAnExpectedIsActiveEqualsFalse_whenCallNewCategoryAndValidate_thenInstantiateACategory() {
    final String expectedName = "Filmes";
    final var expectedDescription = "A categoria mais assistida";
    final var expectedIsActive = false;

    final var actualCategory =
        Category.newCategory(expectedName, expectedDescription, expectedIsActive);

    Assertions.assertDoesNotThrow(() -> actualCategory.validate(new ThrowsValidationHandler()));

    Assertions.assertNotNull(actualCategory);
    Assertions.assertNotNull(actualCategory.getId());
    Assertions.assertEquals(expectedName, actualCategory.getName());
    Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
    Assertions.assertEquals(expectedIsActive, actualCategory.isActive());
    Assertions.assertNotNull(actualCategory.getCreatedAt());
    Assertions.assertNotNull(actualCategory.getUpdatedAt());
    Assertions.assertNotNull(actualCategory.getDeletedAt());
  }
}
