package com.turkcell.library_cqrs.interfaces.web;

import com.turkcell.library_cqrs.application.loan.command.UpdateLoanCommand;
import com.turkcell.library_cqrs.application.loan.dto.GetLoanByIdResponse;
import com.turkcell.library_cqrs.application.loan.dto.UpdateLoanResponse;
import com.turkcell.library_cqrs.application.loan.query.GetLoanByIdQuery;
import com.turkcell.library_cqrs.application.loan.query.GetLoanByIdQueryHandler;
import com.turkcell.library_cqrs.core.cqrs.CommandHandler;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/loans")
public class LoanController {

    private final GetLoanByIdQueryHandler getLoanByIdQueryHandler;
    private final CommandHandler<UpdateLoanCommand, UpdateLoanResponse> updateLoanCommandHandler;


    public LoanController(GetLoanByIdQueryHandler getLoanByIdQueryHandler, CommandHandler<UpdateLoanCommand, UpdateLoanResponse> updateLoanCommandHandler) {
        this.getLoanByIdQueryHandler = getLoanByIdQueryHandler;
        this.updateLoanCommandHandler = updateLoanCommandHandler;
    }

    @GetMapping("{/id}")
    public GetLoanByIdResponse getById(@Valid GetLoanByIdQuery query){
        return getLoanByIdQueryHandler.handle(query);
    }

    @PostMapping()
    public UpdateLoanResponse update(@RequestBody UpdateLoanCommand command){
        return updateLoanCommandHandler.handle(command);
    }

}
