package com.turkcell.library_cqrs.domain.loan.model;


import com.turkcell.library_cqrs.domain.member.model.MemberId;

public class Loan {

    private final LoanId id;
    private LoanPeriod loanPeriod;

    private LoanStatus status;
    //ilişkilerin kurulur
    private MemberId memberId;
    private


    public Loan(LoanId id,LoanPeriod loanPeriod, LoanStatus status) {
        this.id = id;
        this.loanPeriod=loanPeriod;
        this.status = status;
    }

    public static Loan create(){
        
    }
}
