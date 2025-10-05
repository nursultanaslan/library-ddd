package com.turkcell.library_cqrs.application.fine.command;

import com.turkcell.library_cqrs.application.fine.dto.CreateFineResponse;
import com.turkcell.library_cqrs.core.cqrs.Command;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record CreateFineCommand(
        @Positive BigDecimal amount,
        @NotBlank @Size(min = 2, max = 50) String currency,
        @NotNull LocalDate fineDate,
        @NotNull Boolean isPaid,
        @NotNull UUID memberId
) implements Command<CreateFineResponse> {
}
