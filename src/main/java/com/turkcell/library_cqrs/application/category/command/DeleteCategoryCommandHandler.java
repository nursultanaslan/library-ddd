package com.turkcell.library_cqrs.application.category.command;

import com.turkcell.library_cqrs.application.category.dto.DeletedCategoryResponse;
import com.turkcell.library_cqrs.application.category.mapper.DeleteCategoryMapper;
import com.turkcell.library_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_cqrs.domain.category.model.Category;
import com.turkcell.library_cqrs.domain.category.model.CategoryId;
import com.turkcell.library_cqrs.domain.category.repository.CategoryRepository;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

@Component
public class DeleteCategoryCommandHandler implements CommandHandler<DeleteCategoryCommand, DeletedCategoryResponse> {
    private final CategoryRepository repository;
    private final DeleteCategoryMapper categoryMapper;

    public DeleteCategoryCommandHandler(CategoryRepository repository, DeleteCategoryMapper categoryMapper) {
        this.repository = repository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public DeletedCategoryResponse handle(DeleteCategoryCommand command) {
        Category category = repository.findById(new CategoryId(command.id()))
                .orElse(null);
        if(category == null)
            throw new NotFoundException("Category not found");

        repository.delete(category);
        return categoryMapper.toResponse(category);
    }
}
