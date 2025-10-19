package com.turkcell.library_cqrs.interfaces.web;

import com.turkcell.library_cqrs.application.category.command.CreateCategoryCommand;
import com.turkcell.library_cqrs.application.category.command.DeleteCategoryCommand;
import com.turkcell.library_cqrs.application.category.dto.CategoryResponse;
import com.turkcell.library_cqrs.application.category.dto.DeletedCategoryResponse;
import com.turkcell.library_cqrs.application.category.query.ListCategoriesQuery;
import com.turkcell.library_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_cqrs.core.cqrs.QueryHandler;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@Validated
public class CategoriesController {

    private final CommandHandler<CreateCategoryCommand, CategoryResponse> createCategoryCommandHandler;
    private final QueryHandler<ListCategoriesQuery, List<CategoryResponse>> listCategoryQueryHandler;
    private final CommandHandler<DeleteCategoryCommand, DeletedCategoryResponse> deleteCategoryCommandHandler;

    public CategoriesController(CommandHandler<CreateCategoryCommand, CategoryResponse> createCategoryCommandHandler, QueryHandler<ListCategoriesQuery, List<CategoryResponse>> listCategoryQueryHandler, CommandHandler<DeleteCategoryCommand, DeletedCategoryResponse> deleteCategoryCommandHandler) {
        this.createCategoryCommandHandler = createCategoryCommandHandler;
        this.listCategoryQueryHandler = listCategoryQueryHandler;
        this.deleteCategoryCommandHandler = deleteCategoryCommandHandler;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse create(@Valid @RequestBody CreateCategoryCommand command){
        return createCategoryCommandHandler.handle(command);
    }

    @GetMapping
    public List<CategoryResponse> getCategories(@Valid ListCategoriesQuery query){
        return listCategoryQueryHandler.handle(query);
    }

    @DeleteMapping("/{id}")
    public DeletedCategoryResponse delete(DeleteCategoryCommand command){
        return deleteCategoryCommandHandler.handle(command);
    }


}
