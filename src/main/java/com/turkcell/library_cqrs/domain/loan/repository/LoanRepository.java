package com.turkcell.library_cqrs.domain.loan.repository;

import com.turkcell.library_cqrs.domain.loan.model.Loan;
import com.turkcell.library_cqrs.domain.loan.model.LoanId;

import java.util.List;
import java.util.Optional;

public interface LoanRepository {
    Loan save(Loan loan);
    Optional<Loan> findById(LoanId loanId);
    List<Loan> findAll();
    List<Loan> findAllPaged(Integer pageIndex, Integer pageSize);
    void delete(LoanId loanId);
}
