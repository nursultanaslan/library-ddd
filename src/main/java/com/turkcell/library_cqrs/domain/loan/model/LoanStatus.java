package com.turkcell.library_cqrs.domain.loan.model;

public enum LoanStatus {
    OPEN,  // The book has been borrowed and not returned yet
    CLOSED, // The book was returned
    DELAYED  // The book is overdue but has not been returned yet
}
