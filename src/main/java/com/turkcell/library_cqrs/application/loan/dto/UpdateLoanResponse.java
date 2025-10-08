package com.turkcell.library_cqrs.application.loan.dto;

import com.turkcell.library_cqrs.domain.loan.model.LoanStatus;

import java.time.LocalDate;
import java.util.UUID;

public record UpdateLoanResponse(
        UUID id,
        LocalDate loanDate,
        LocalDate dueDate,
        LocalDate returnDate,
        LoanStatus loanStatus,
        UUID memberId,
        UUID bookItemId
) {
}
