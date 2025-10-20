package com.turkcell.library_cqrs.application.category.command;

import com.turkcell.library_cqrs.application.category.dto.DeletedCategoryResponse;
import com.turkcell.library_cqrs.core.cqrs.Command;

import java.util.UUID;

public record DeleteCategoryCommand(UUID id) implements Command<DeletedCategoryResponse> {
}
