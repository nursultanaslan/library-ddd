package com.turkcell.library_cqrs.application.loan.mapper;

import com.turkcell.library_cqrs.application.loan.command.CreateLoanCommand;
import com.turkcell.library_cqrs.application.loan.dto.CreateLoanResponse;
import com.turkcell.library_cqrs.domain.bookItems.model.BookItemsId;
import com.turkcell.library_cqrs.domain.loan.model.Loan;
import com.turkcell.library_cqrs.domain.loan.model.LoanPeriod;
import com.turkcell.library_cqrs.domain.member.model.MemberId;

public class CreateLoanMapper {

    public Loan toDomain(CreateLoanCommand createLoanCommand) {
        return Loan.create(
                new LoanPeriod(createLoanCommand.loanPeriod().loanDate()
                        , createLoanCommand.loanPeriod().dueDate(), createLoanCommand.loanPeriod().returnDate()),
                createLoanCommand.loanStatus(),
                new MemberId(createLoanCommand.memberId()),
                new BookItemsId(createLoanCommand.bookItemsId())
        );
    }
        public CreateLoanResponse toResponse(Loan loan){
            return new CreateLoanResponse(
                    loan.getId().value(),
                    loan.getLoanPeriod().loanDate(),
                    loan.getLoanPeriod().dueDate(),
                    loan.getLoanPeriod().returnDate(),
                    loan.getLoanStatus()
            );
    }
}
