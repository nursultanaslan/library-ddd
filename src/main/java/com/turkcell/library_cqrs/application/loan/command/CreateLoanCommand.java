package com.turkcell.library_cqrs.application.loan.command;

import com.turkcell.library_cqrs.application.loan.dto.CreateLoanResponse;
import com.turkcell.library_cqrs.core.cqrs.Command;
import com.turkcell.library_cqrs.domain.loan.model.LoanPeriod;
import com.turkcell.library_cqrs.domain.loan.model.LoanStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateLoanCommand(
        @NotNull LoanPeriod loanPeriod,
        @NotBlank LoanStatus loanStatus,
        @NotNull UUID memberId,
        @NotNull UUID bookItemsId
) implements Command<CreateLoanResponse> {
}
