package com.turkcell.library_cqrs.application.category.command;

import com.turkcell.library_cqrs.application.category.dto.CategoryResponse;
import com.turkcell.library_cqrs.application.category.mapper.CreateCategoryMapper;
import com.turkcell.library_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_cqrs.domain.category.model.Category;
import com.turkcell.library_cqrs.domain.category.repository.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateCategoryCommandHandler implements CommandHandler<CreateCategoryCommand, CategoryResponse> {
    private final CreateCategoryMapper categoryMapper;
    private final CategoryRepository repository;

    public CreateCategoryCommandHandler(CreateCategoryMapper categoryMapper, CategoryRepository repository) {
        this.categoryMapper = categoryMapper;
        this.repository = repository;
    }

    @Override
    public CategoryResponse handle(CreateCategoryCommand command) {
        Category category = categoryMapper.toDomain(command);
        category = repository.save(category);
        return categoryMapper.toResponse(category);
    }
}
