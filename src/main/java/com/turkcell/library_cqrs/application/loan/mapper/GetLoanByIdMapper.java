package com.turkcell.library_cqrs.application.loan.mapper;

import com.turkcell.library_cqrs.application.loan.dto.GetLoanByIdResponse;
import com.turkcell.library_cqrs.domain.loan.model.Loan;
import org.springframework.stereotype.Component;

@Component
public class GetLoanByIdMapper {

    public GetLoanByIdResponse toResponse(Loan loan) {
        return new GetLoanByIdResponse(
                loan.getId().value(),
                loan.getLoanPeriod().loanDate(),
                loan.getLoanPeriod().dueDate(),
                loan.getLoanPeriod().returnDate(), // can be null
                loan.getLoanStatus(),
                loan.getMemberId().value(),
                loan.getBookItemsId().value()
        );
    }
}
