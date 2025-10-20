package com.turkcell.library_cqrs.application.fine.mapper;

import com.turkcell.library_cqrs.application.fine.command.CreateFineCommand;
import com.turkcell.library_cqrs.application.fine.dto.CreateFineResponse;
import com.turkcell.library_cqrs.domain.fine.model.Fine;
import com.turkcell.library_cqrs.domain.fine.model.FineAmount;
import com.turkcell.library_cqrs.domain.loan.model.LoanId;
import com.turkcell.library_cqrs.domain.member.model.MemberId;
import org.springframework.stereotype.Component;

@Component
public class CreateFineMapper {

    public Fine toDomain(CreateFineCommand command){
        return Fine.create(
                new FineAmount(command.amount(), command.currency()),
                command.fineDate(),
                command.isPaid(),
                new MemberId(command.memberId()),
                new LoanId(command.loanId())

        );
    }


    public CreateFineResponse toResponse(Fine fine){
        return new CreateFineResponse(
                fine.id().value(),
                fine.memberId().value(),
                fine.amount().value(),
                fine.amount().currency(),
                fine.fineDate(),
                fine.isPaid()
        );
    }
}
