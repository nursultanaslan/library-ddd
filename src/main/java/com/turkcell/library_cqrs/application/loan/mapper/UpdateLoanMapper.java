package com.turkcell.library_cqrs.application.loan.mapper;

import com.turkcell.library_cqrs.application.loan.command.UpdateLoanCommand;
import com.turkcell.library_cqrs.application.loan.dto.UpdateLoanResponse;
import com.turkcell.library_cqrs.domain.bookItems.model.BookItemsId;
import com.turkcell.library_cqrs.domain.loan.model.Loan;
import com.turkcell.library_cqrs.domain.loan.model.LoanId;
import com.turkcell.library_cqrs.domain.loan.model.LoanPeriod;
import com.turkcell.library_cqrs.domain.member.model.MemberId;

public class UpdateLoanMapper {

    public Loan toDomain(UpdateLoanCommand loan){
        return new Loan(
                new LoanId(loan.loanId()),
                new LoanPeriod(loan.loanPeriod().loanDate(),
                        loan.loanPeriod().dueDate(),loan.loanPeriod().returnDate()),
                loan.loanStatus(),
                new MemberId(loan.memberId()),
                new BookItemsId(loan.bookItemsId())
        );
    }

    public UpdateLoanResponse toResponse(Loan loan){
        return new UpdateLoanResponse(
                loan.getId().value(),
                loan.getLoanPeriod().loanDate(),
                loan.getLoanPeriod().dueDate(),
                loan.getLoanPeriod().returnDate(),
                loan.getLoanStatus(),
                loan.getMemberId().value(),
                loan.getBookItemsId().value()
        );
    }
}
