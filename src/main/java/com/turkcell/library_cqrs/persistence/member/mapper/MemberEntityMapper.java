package com.turkcell.library_cqrs.persistence.member.mapper;

import com.turkcell.library_cqrs.domain.member.model.*;
import com.turkcell.library_cqrs.persistence.member.entity.JpaMemberEntity;
import org.springframework.stereotype.Component;

@Component
public class MemberEntityMapper {

    //Member -> JpaMemberEntity
    public JpaMemberEntity toEntity(Member member){
        JpaMemberEntity entity = new JpaMemberEntity();
        entity.setId(member.id().value());
        entity.setFirstName(entity.firstName());
        entity.setLastName(entity.lastName());
        entity.setEmail(entity.email());
        entity.setPassword(entity.password());
        entity.setUsername(entity.username());
        entity.setPhone(entity.phone());
        entity.setMembershipLevel(entity.membershipLevel());
        entity.setMemberStatus(entity.memberStatus());
        return entity;
    }


    //JpaMemberEntity -> Member
    public Member toDomain(JpaMemberEntity entity){
        return Member.rehydrate(
            new MemberId(entity.id()),
                entity.firstName(),
                entity.lastName(),
                new Email(entity.email()),
                new Username(entity.username()),
                entity.password(),
                new Phone(entity.phone()),
                entity.membershipLevel(),
                entity.memberStatus()
        );
    }

}
