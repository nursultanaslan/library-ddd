package com.turkcell.library_cqrs.persistence.fine.mapper;

import com.turkcell.library_cqrs.domain.fine.model.Fine;
import com.turkcell.library_cqrs.domain.fine.model.FineAmount;
import com.turkcell.library_cqrs.domain.fine.model.FineId;
import com.turkcell.library_cqrs.domain.loan.model.LoanId;
import com.turkcell.library_cqrs.domain.member.model.MemberId;
import com.turkcell.library_cqrs.persistence.fine.entity.JpaFineEntity;
import com.turkcell.library_cqrs.persistence.loan.JpaLoanEntity;
import com.turkcell.library_cqrs.persistence.member.entity.JpaMemberEntity;
import org.springframework.stereotype.Component;

@Component
public class FineEntityMapper {

    public JpaFineEntity toEntity(Fine fine){
        JpaFineEntity entity = new JpaFineEntity();
        entity.setId(fine.id().value());
        entity.setAmount(fine.amount().value());
        entity.setCurrency(fine.amount().currency());
        entity.setFineDate(fine.fineDate());
        entity.setPaid(fine.isPaid());
        entity.setMember(new JpaMemberEntity(fine.memberId().value()));
        entity.setLoan(new JpaLoanEntity(fine.loanId().value()));
        return entity;
    }

    //veritabanından okudugunu domaine cevir
    public Fine toDomain(JpaFineEntity entity){
        return Fine.rehydrate(
                new FineId(entity.id()),
                new FineAmount(entity.amount(), entity.currency()),
                entity.fineDate(),
                entity.isPaid(),
                new MemberId(entity.id()),
                new LoanId(entity.id())
        );
    }
}
