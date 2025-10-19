package com.turkcell.library_cqrs.application.fine.query;

import com.turkcell.library_cqrs.application.fine.dto.FineResponse;
import com.turkcell.library_cqrs.core.cqrs.Query;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record GetFineByIdQuery(@NotNull UUID id) implements Query<FineResponse> {
}
