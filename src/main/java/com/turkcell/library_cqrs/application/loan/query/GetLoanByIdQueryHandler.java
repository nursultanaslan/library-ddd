package com.turkcell.library_cqrs.application.loan.query;

import com.turkcell.library_cqrs.application.loan.dto.GetLoanByIdResponse;
import com.turkcell.library_cqrs.application.loan.mapper.GetLoanByIdMapper;
import com.turkcell.library_cqrs.core.cqrs.QueryHandler;
import com.turkcell.library_cqrs.domain.loan.model.Loan;
import com.turkcell.library_cqrs.domain.loan.model.LoanId;
import com.turkcell.library_cqrs.domain.loan.repository.LoanRepository;
import org.springframework.stereotype.Component;

@Component
public class GetLoanByIdQueryHandler implements QueryHandler<GetLoanByIdQuery, GetLoanByIdResponse> {

    private final LoanRepository loanRepository;
    private final GetLoanByIdMapper mapper;

    public GetLoanByIdQueryHandler(LoanRepository loanRepository, GetLoanByIdMapper mapper) {
        this.loanRepository = loanRepository;
        this.mapper = mapper;
    }

    @Override
    public GetLoanByIdResponse handle(GetLoanByIdQuery query) {
        Loan loan = loanRepository.findById(new LoanId(query.loanId()))
                .orElseThrow(() -> new RuntimeException("Loan not found: " + query.loanId()));

        return mapper.toResponse(loan);
    }
}
