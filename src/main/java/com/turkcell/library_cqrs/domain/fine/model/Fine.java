package com.turkcell.library_cqrs.domain.fine.model;

import com.turkcell.library_cqrs.domain.loan.model.LoanId;
import com.turkcell.library_cqrs.domain.member.model.MemberId;

import java.time.LocalDate;
import java.util.Objects;

public class Fine {

    private final FineId id;

    private FineAmount amount;
    private LocalDate fineDate;
    private Boolean isPaid;

    private MemberId memberId;
    private LoanId loanId;

    //controller constructor
    public Fine(FineId id, FineAmount amount, LocalDate fineDate, Boolean isPaid, MemberId memberId, LoanId loanId) {
        this.id = id;
        this.amount = amount;
        this.fineDate = fineDate;
        this.isPaid = isPaid;
        this.memberId = memberId;
        this.loanId = loanId;
    }

    //create method
    public static Fine create(FineAmount amount, LocalDate fineDate, Boolean isPaid, MemberId memberId, LoanId loanId){
        Objects.requireNonNull(amount, "Amount cannot be null");
        Objects.requireNonNull(memberId, "Member id cannot be null");
        Objects.requireNonNull(loanId, "Loan id cannot be null");
        validateDate(fineDate);
        return new Fine(
                FineId.generate(),
                amount,
                fineDate,
                isPaid,
                memberId,
                loanId
        );
    }

    //rehydrate method
    public static Fine rehydrate(FineId id, FineAmount amount, LocalDate fineDate, Boolean isPaid, MemberId memberId, LoanId loanId)
    {
        return new Fine(
                id,
                amount,
                fineDate,
                isPaid,
                memberId,
                loanId
        );
    }

    //worker methods
    public void pay(){
        if(this.isPaid){
            throw new IllegalArgumentException("Fine is already paid");
        }
        this.isPaid = true;
    }

    //validations
    private static void validateDate(LocalDate fineDate){
        Objects.requireNonNull(fineDate, "Fine date cannot be null");
    }


    //getters
    public FineId id() {
        return id;
    }

    public FineAmount amount() {
        return amount;
    }

    public LocalDate fineDate() {
        return fineDate;
    }

    public Boolean isPaid() {
        return isPaid;
    }

    public MemberId memberId() {
        return memberId;
    }

    public LoanId loanId() {
        return loanId;
    }
}
