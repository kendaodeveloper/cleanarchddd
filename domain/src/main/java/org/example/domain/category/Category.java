package org.example.domain.category;

import java.time.Instant;
import java.util.UUID;

public class Category {
  public String id;
  public String name;
  public String description;
  public boolean active;
  public Instant createdAt;
  public Instant updatedAt;
  public Instant deletedAt;

  private Category(
      String id, String name, String description, boolean active, Instant createdAt, Instant updatedAt, Instant deletedAt
  ) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.active = active;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.deletedAt = deletedAt;
  }

  public static Category newCategory(String name, String description, boolean active) {
    return new Category(
        UUID.randomUUID().toString(),
        name,
        description,
        active,
        Instant.now(),
        Instant.now(),
        null
    );
  }

  public String getId() {
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
}
