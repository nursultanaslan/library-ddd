package com.turkcell.library_cqrs.persistence.fine.entity;

import com.turkcell.library_cqrs.domain.member.model.Member;
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
    private Member member;

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

    public Member member() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
