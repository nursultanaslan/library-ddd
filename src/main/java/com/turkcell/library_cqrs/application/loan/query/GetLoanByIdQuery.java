package com.turkcell.library_cqrs.application.loan.query;

import com.turkcell.library_cqrs.application.loan.dto.GetLoanByIdResponse;
import com.turkcell.library_cqrs.core.cqrs.Query;

import java.util.UUID;

public record GetLoanByIdQuery(UUID loanId) implements Query<GetLoanByIdResponse> {

}

