package com.turkcell.library_cqrs.application.member.mapper;

import com.turkcell.library_cqrs.application.member.command.UpdateMemberCommand;
import com.turkcell.library_cqrs.application.member.dto.UpdatedMemberResponse;
import com.turkcell.library_cqrs.domain.member.model.Email;
import com.turkcell.library_cqrs.domain.member.model.Member;
import com.turkcell.library_cqrs.domain.member.model.Phone;
import com.turkcell.library_cqrs.domain.member.model.Username;
import org.springframework.stereotype.Component;

@Component
public class UpdateMemberMapper {

    public Member toDomain(UpdateMemberCommand command){
        return Member.create(
                command.firstName(),
                command.lastName(),
                new Email(command.email()),
                new Username(command.username()),
                command.password(),
                new Phone(command.phone())
        );
    }

    public UpdatedMemberResponse toResponse(Member member){

        return new UpdatedMemberResponse(
                member.id().value(),
                member.firstName(),
                member.lastName(),
                member.username()
        );
    }
}
