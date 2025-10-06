package com.turkcell.library_cqrs.application.member.mapper;

import com.turkcell.library_cqrs.application.member.dto.DeletedMemberResponse;
import com.turkcell.library_cqrs.domain.member.model.Member;
import org.springframework.stereotype.Component;

@Component
public class DeleteMemberMapper {

    public DeletedMemberResponse toResponse(Member member){
        return new DeletedMemberResponse(
                member.id().value()
        );
    }

}
