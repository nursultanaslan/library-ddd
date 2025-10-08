package com.turkcell.library_cqrs.domain.loan.model;

import com.turkcell.library_cqrs.domain.bookItems.model.BookItemsId;
import com.turkcell.library_cqrs.domain.member.model.MemberId;

import java.util.Objects;

public class Loan {

    private final LoanId id;

    //loan_date+due_date+return_date
    private LoanPeriod loanPeriod;
    private LoanStatus loanStatus;

    //Relations
    private MemberId memberId;
    private BookItemsId bookItemsId;

    public Loan(LoanId id, LoanPeriod loanPeriod, LoanStatus loanStatus, MemberId memberId,BookItemsId bookItemsId) {
        this.id = id;
        this.loanPeriod = loanPeriod;
        this.loanStatus = loanStatus;
        this.memberId = memberId;
        this.bookItemsId = bookItemsId;
    }

    public static Loan create(LoanPeriod loanPeriod,LoanStatus loanStatus,MemberId memberId,BookItemsId bookItemsId){
        Objects.requireNonNull(loanPeriod,"Loan Period cannot be null");
        Objects.requireNonNull(loanStatus);
        Objects.requireNonNull(memberId,"MemberId cannot be null");
        Objects.requireNonNull(bookItemsId,"BookItemsId cannot be null");
        return new Loan(LoanId.generate(),
                loanPeriod,
                loanStatus,
                memberId,bookItemsId);
    }
    //To reload the object read from the database into the domain
    public static Loan rehydrate(LoanId id,LoanPeriod loanPeriod,LoanStatus loanStatus,MemberId memberId,BookItemsId bookItemsId){
        return new Loan(id,loanPeriod,loanStatus,memberId,bookItemsId);
    }

    public void markAsDelayed() {
        if (loanStatus != LoanStatus.OPEN) {
            throw new IllegalStateException("Only open loans can be marked as delayed.");
        }
        this.loanStatus = LoanStatus.DELAYED;
    }

    public void closeLoan() {
        if (loanStatus == LoanStatus.CLOSED) {
            throw new IllegalStateException("Loan is already closed.");
        }
        this.loanStatus = LoanStatus.CLOSED;
    }

    public void updateLoan(LoanPeriod newPeriod, LoanStatus newStatus) {
        if (this.loanStatus == LoanStatus.CLOSED) {
            throw new IllegalStateException("Closed loans cannot be modified.");
        }
        if (newPeriod != null) {
            this.loanPeriod = newPeriod;
        }
        if (newStatus != null) {
            this.loanStatus = newStatus;
        }
    }


    public boolean isOverdue() {
        return loanPeriod.isOverdue() && loanStatus == LoanStatus.OPEN;
    }

    public LoanId getId() {
        return id;
    }

    public LoanPeriod getLoanPeriod() {
        return loanPeriod;
    }

    public LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public MemberId getMemberId() {
        return memberId;
    }

    public BookItemsId getBookItemsId() {
        return bookItemsId;
    }
}
