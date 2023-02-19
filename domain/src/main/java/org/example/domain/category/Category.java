package org.example.domain.category;

import org.example.domain.AggregateRoot;
import org.example.domain.validation.ValidationHandler;

import java.time.Instant;

public class Category extends AggregateRoot<CategoryID> {
  public String name;
  public String description;
  public boolean active;
  public Instant createdAt;
  public Instant updatedAt;
  public Instant deletedAt;

  private Category(
      CategoryID id,
      String name,
      String description,
      boolean active,
      Instant createdAt,
      Instant updatedAt,
      Instant deletedAt
  ) {
    super(id);
    this.name = name;
    this.description = description;
    this.active = active;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.deletedAt = deletedAt;
  }

  public static Category newCategory(String name, String description, boolean active) {
    return new Category(
        CategoryID.unique(),
        name,
        description,
        active,
        Instant.now(),
        Instant.now(),
        active ? null : Instant.now()
    );
  }

  public CategoryID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public boolean isActive() {
    return active;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public Instant getDeletedAt() {
    return deletedAt;
  }

  @Override
  public void validate(final ValidationHandler handler) {
    new CategoryValidator(this, handler).validate();
  }
}
