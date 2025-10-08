package com.turkcell.library_cqrs.application.loan.command;

import com.turkcell.library_cqrs.application.loan.dto.CreateLoanResponse;
import com.turkcell.library_cqrs.application.loan.mapper.CreateLoanMapper;
import com.turkcell.library_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_cqrs.domain.loan.model.Loan;
import com.turkcell.library_cqrs.domain.loan.repository.LoanRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateLoanCommandHandler implements CommandHandler<CreateLoanCommand, CreateLoanResponse> {
    private final CreateLoanMapper createLoanMapper;
    private final LoanRepository loanRepository;

    public CreateLoanCommandHandler(CreateLoanMapper createLoanMapper, LoanRepository loanRepository) {
        this.createLoanMapper = createLoanMapper;
        this.loanRepository = loanRepository;
    }

    @Override
    public CreateLoanResponse handle(CreateLoanCommand command) {
        Loan loan=createLoanMapper.toDomain(command);
        loan=loanRepository.save(loan);
        return createLoanMapper.toResponse(loan);
    }
}
