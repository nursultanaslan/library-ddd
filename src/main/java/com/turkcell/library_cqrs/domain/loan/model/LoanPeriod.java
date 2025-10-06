package com.turkcell.library_cqrs.domain.loan.model;

import java.time.LocalDate;
import java.util.Objects;

public record LoanPeriod(LocalDate loanDate, LocalDate dueDate, LocalDate returnDate) {
    public LoanPeriod{
        Objects.requireNonNull(loanDate, "Loan date cannot be null");
        Objects.requireNonNull(dueDate,"Due date cannot be null");

        // returnDate can be null because the book has not been returned yet

        if (dueDate.isBefore(loanDate)) {
            throw new IllegalArgumentException("Due date cannot be before loan date");
        }

        if (returnDate != null && returnDate.isBefore(loanDate)) {
            throw new IllegalArgumentException("Return date cannot be before loan date");
        }
    }

    //Still not returned and expired?
    public boolean isOverdue() {
        return dueDate.isBefore(LocalDate.now()) && returnDate == null;
    }
}
