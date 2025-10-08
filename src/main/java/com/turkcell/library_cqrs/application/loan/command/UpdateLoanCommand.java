package com.turkcell.library_cqrs.application.loan.command;

import com.turkcell.library_cqrs.application.loan.dto.UpdateLoanResponse;
import com.turkcell.library_cqrs.core.cqrs.Command;
import com.turkcell.library_cqrs.domain.loan.model.LoanPeriod;
import com.turkcell.library_cqrs.domain.loan.model.LoanStatus;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record UpdateLoanCommand(
        @NotNull UUID loanId,
        LoanPeriod loanPeriod,
        LoanStatus loanStatus,
        UUID memberId,
        UUID bookItemsId
) implements Command<UpdateLoanResponse> {
}

