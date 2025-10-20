package com.turkcell.library_cqrs.application.category.mapper;

import com.turkcell.library_cqrs.application.category.dto.DeletedCategoryResponse;
import com.turkcell.library_cqrs.domain.category.model.Category;
import org.springframework.stereotype.Component;

@Component
public class DeleteCategoryMapper {

    public DeletedCategoryResponse toResponse(Category category){
        return new DeletedCategoryResponse(
                category.id().value()
        );
    }
}
