package org.example.infraestructure.category.persistence;

import org.example.domain.category.Category;
import org.example.domain.category.CategoryID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "category")
public class CategoryTable {
  @Id
  private String id;
  @Column(name = "name", nullable = false)
  private String name;
  @Column(name = "description", length = 1000)
  private String description;
  @Column(name = "active", nullable = false)
  private boolean active;
  @Column(name = "created_at", nullable = false, columnDefinition = "DATETIME(6)")
  private Instant createdAt;
  @Column(name = "updated_at", nullable = false, columnDefinition = "DATETIME(6)")
  private Instant updatedAt;
  @Column(name = "deleted_at", columnDefinition = "DATETIME(6)")
  private Instant deletedAt;

  private CategoryTable(
      final String id,
      final String name,
      final String description,
      final boolean active,
      final Instant createdAt,
      final Instant updatedAt,
      final Instant deletedAt) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.active = active;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.deletedAt = deletedAt;
  }

  public static CategoryTable from(final Category category) {
    return new CategoryTable(
        category.getId().getValue(),
        category.getName(),
        category.getDescription(),
        category.isActive(),
        category.getCreatedAt(),
        category.getUpdatedAt(),
        category.getDeletedAt()
    );
  }

  public Category toAggregate() {
    return Category.with(
        CategoryID.from(getId()),
        getName(),
        getDescription(),
        isActive(),
        getCreatedAt(),
        getUpdatedAt(),
        getDeletedAt()
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
