package com.turkcell.library_cqrs.application.member.mapper;

import com.turkcell.library_cqrs.application.member.dto.GetByIdMemberResponse;
import com.turkcell.library_cqrs.domain.member.model.Member;
import org.springframework.stereotype.Component;

@Component
public class GetByIdMemberMapper {

    public GetByIdMemberResponse toResponse(Member member){
        return new GetByIdMemberResponse(
            member.id().value(),
            member.firstName(),
            member.lastName(),
            member.username().value()
        );
    }
}
