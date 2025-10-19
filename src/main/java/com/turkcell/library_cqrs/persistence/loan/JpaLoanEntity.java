package com.turkcell.library_cqrs.persistence.loan;

import com.turkcell.library_cqrs.domain.bookItems.model.BookItems;
import com.turkcell.library_cqrs.domain.loan.model.LoanStatus;
import com.turkcell.library_cqrs.domain.member.model.Member;
import com.turkcell.library_cqrs.persistence.fine.entity.JpaFineEntity;
import com.turkcell.library_cqrs.persistence.member.entity.JpaMemberEntity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "loans")
public class JpaLoanEntity {

    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(name = "loanDate",nullable = false)
    LocalDate loanDate;
    @Column(name = "dueDate",nullable = false)
    LocalDate dueDate;
    @Column(name = "returnDate",nullable = false)
    LocalDate returnDate;

    @Enumerated(EnumType.STRING)
    private LoanStatus loanStatus;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private JpaMemberEntity member;

    /*@ManyToOne      TODO: BookItems persistence layer will be created
    @JoinColumn(name = "bookItems_id", nullable = false)
    private JpaBookItemsEntity bookItems;*/
    @OneToMany(mappedBy = "loan")
    private List<JpaFineEntity> fines;

    public JpaLoanEntity() {
    }

    public JpaLoanEntity(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
    }

    public JpaMemberEntity getMember() {
        return member;
    }

    public void setMember(JpaMemberEntity member) {
        this.member = member;
    }

    public List<JpaFineEntity> fines() {
        return fines;
    }

    public void setFines(List<JpaFineEntity> fines) {
        this.fines = fines;
    }
}
