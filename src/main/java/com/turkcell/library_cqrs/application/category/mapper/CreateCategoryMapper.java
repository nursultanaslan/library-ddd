package com.turkcell.library_cqrs.application.category.mapper;

import com.turkcell.library_cqrs.application.category.command.CreateCategoryCommand;
import com.turkcell.library_cqrs.application.category.dto.CategoryResponse;
import com.turkcell.library_cqrs.domain.category.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CreateCategoryMapper {

    public CategoryResponse toResponse(Category category){
        return new CategoryResponse(
                category.id().value(),
                category.name()
        );
    }

    public Category toDomain(CreateCategoryCommand command){
        return Category.create(
                command.name()
        );
    }
}
