package org.example.domain.category;

import org.example.domain.enumerable.SortDirection;

public record CategorySearchQuery(
    int currentPage,
    int itemsPerPage,
    String terms,
    String sortColumn,
    SortDirection sortDirection
) {
}
