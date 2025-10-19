package com.turkcell.library_cqrs.persistence.fine.entity;

import com.turkcell.library_cqrs.persistence.loan.JpaLoanEntity;
import com.turkcell.library_cqrs.persistence.member.entity.JpaMemberEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "fines")
public class JpaFineEntity {
    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;
    @Column(name = "amount", nullable = false, precision = 18, scale = 2)
    private BigDecimal amount;
    @Column(name = "currency", nullable = false)
    private String currency;
    @Column(name = "fine_date", nullable = false)
    private LocalDate fineDate;
    @Column(name = "is_paid", nullable = false)
    private Boolean isPaid;

    @ManyToOne()
    @JoinColumn(name = "member_id", nullable = false)
    private JpaMemberEntity member;

    @ManyToOne()
    @JoinColumn(name = "loan_id", nullable = false)
    private JpaLoanEntity loan;

    public UUID id() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal amount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String currency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate fineDate() {
        return fineDate;
    }

    public void setFineDate(LocalDate fineDate) {
        this.fineDate = fineDate;
    }

    public Boolean isPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public JpaMemberEntity member() {
        return member;
    }

    public void setMember(JpaMemberEntity member) {
        this.member = member;
    }

    public JpaLoanEntity loan() {
        return loan;
    }

    public void setLoan(JpaLoanEntity loan) {
        this.loan = loan;
    }
}
