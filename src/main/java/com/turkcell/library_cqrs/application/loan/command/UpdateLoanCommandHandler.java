package com.turkcell.library_cqrs.application.loan.command;

import com.turkcell.library_cqrs.application.loan.dto.UpdateLoanResponse;
import com.turkcell.library_cqrs.application.loan.mapper.UpdateLoanMapper;
import com.turkcell.library_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_cqrs.domain.loan.model.Loan;
import com.turkcell.library_cqrs.domain.loan.model.LoanId;
import com.turkcell.library_cqrs.domain.loan.repository.LoanRepository;
import org.springframework.stereotype.Component;

@Component
public class UpdateLoanCommandHandler implements CommandHandler<UpdateLoanCommand, UpdateLoanResponse> {

    private final LoanRepository loanRepository;
    private final UpdateLoanMapper updateLoanMapper;

    public UpdateLoanCommandHandler(LoanRepository loanRepository, UpdateLoanMapper updateLoanMapper) {
        this.loanRepository = loanRepository;
        this.updateLoanMapper = updateLoanMapper;
    }

    @Override
    public UpdateLoanResponse handle(UpdateLoanCommand command) {
        Loan loan = loanRepository.findById(new LoanId(command.loanId()))
                .orElseThrow(() -> new IllegalArgumentException("Loan not found"));

        // We use the Domain method the "business logic" stays within the Loan
        loan.updateLoan(command.loanPeriod(), command.loanStatus());

        loanRepository.save(loan);
        return updateLoanMapper.toResponse(loan);
    }
}

