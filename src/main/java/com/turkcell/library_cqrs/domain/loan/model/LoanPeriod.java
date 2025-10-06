package com.turkcell.library_cqrs.domain.loan.model;

import java.time.LocalDate;
import java.util.Objects;

public record LoanPeriod(LocalDate loanDate, LocalDate dueDate, LocalDate returnDate) {
    public LoanPeriod{
        Objects.requireNonNull(loanDate, "Loan date cannot be null");
        Objects.requireNonNull(dueDate,"Due date cannot be null");

        // returnDate null olabilir çünkü kitap henüz iade edilmemiştir

        if (dueDate.isBefore(loanDate)) {
            throw new IllegalArgumentException("Due date cannot be before loan date");
        }

        if (returnDate != null && returnDate.isBefore(loanDate)) {
            throw new IllegalArgumentException("Return date cannot be before loan date");
        }

        // TODO:iş kuralları
    }
}
