package com.turkcell.library_cqrs.persistence.loan;

import com.turkcell.library_cqrs.domain.loan.model.Loan;
import com.turkcell.library_cqrs.domain.loan.model.LoanId;
import com.turkcell.library_cqrs.domain.loan.model.LoanPeriod;

public class LoanEntityMapper {
    public JpaLoanEntity toEntity(Loan loan){
        JpaLoanEntity loanEntity=new JpaLoanEntity();
        loanEntity.setId(loan.getId().value());
        loanEntity.setLoanDate(loan.getLoanPeriod().loanDate());
        loanEntity.setLoanDate(loan.getLoanPeriod().dueDate());
        loanEntity.setLoanDate(loan.getLoanPeriod().returnDate());
        loanEntity.setLoanStatus(loan.getLoanStatus());
        loanEntity.setMember(loanEntity.getMember());
        //loanEntity.setBookItems(loanEntity.getBookItems());

        return loanEntity;
    }

    public Loan toDomain(JpaLoanEntity loanEntity){
        return Loan.rehydrate(
                new LoanId(loanEntity.getId()),
                new LoanPeriod(loanEntity.getLoanDate(),loanEntity.getDueDate(),loanEntity.getReturnDate()),
                loanEntity.getLoanStatus(),
                loanEntity.getMember().id(),
                //loanEntity.getBookItems().getId()
        );
    }
}
