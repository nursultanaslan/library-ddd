package com.turkcell.library_cqrs.application.category.command;

import com.turkcell.library_cqrs.application.category.dto.CategoryResponse;
import com.turkcell.library_cqrs.core.cqrs.Command;
import jakarta.validation.constraints.NotBlank;

public record CreateCategoryCommand(
        @NotBlank String name
) implements Command<CategoryResponse> {
}
