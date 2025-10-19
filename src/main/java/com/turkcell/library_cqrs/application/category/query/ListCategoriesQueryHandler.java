package com.turkcell.library_cqrs.application.category.query;

import com.turkcell.library_cqrs.application.category.dto.CategoryResponse;
import com.turkcell.library_cqrs.application.category.mapper.CategoryResponseMapper;
import com.turkcell.library_cqrs.core.cqrs.QueryHandler;
import com.turkcell.library_cqrs.domain.category.repository.CategoryRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListCategoriesQueryHandler implements QueryHandler<ListCategoriesQuery, List<CategoryResponse>> {

    private final CategoryRepository repository;
    private final CategoryResponseMapper categoryMapper;

    public ListCategoriesQueryHandler(CategoryRepository repository, CategoryResponseMapper categoryMapper) {
        this.repository = repository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryResponse> handle(ListCategoriesQuery query) {
        return repository
                .findAllPaged(query.pageIndex(), query.pageSize())
                .stream()
                .map(categoryMapper::toResponse)
                .toList();

    }
}
