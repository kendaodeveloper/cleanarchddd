package org.example.application.category;

public record CreateCategoryInput(
    String name,
    String description,
    boolean isActive
) {
  public static CreateCategoryInput with(
      String name,
      String description,
      boolean isActive
  ) {
    return new CreateCategoryInput(name, description, isActive);
  }
}
