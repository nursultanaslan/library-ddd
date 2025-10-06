package com.turkcell.library_cqrs.application.member.command;

import com.turkcell.library_cqrs.application.member.dto.DeletedMemberResponse;
import com.turkcell.library_cqrs.application.member.mapper.DeleteMemberMapper;
import com.turkcell.library_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_cqrs.domain.member.model.Member;
import com.turkcell.library_cqrs.domain.member.model.MemberId;
import com.turkcell.library_cqrs.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

@Component
public class DeleteMemberCommandHandler implements CommandHandler<DeleteMemberCommand, DeletedMemberResponse> {

    private final MemberRepository repository;
    private final DeleteMemberMapper memberMapper;

    public DeleteMemberCommandHandler(MemberRepository repository, DeleteMemberMapper memberMapper) {
        this.repository = repository;
        this.memberMapper = memberMapper;
    }

    @Override
    public DeletedMemberResponse handle(DeleteMemberCommand command) {

        Member member = repository.findById(new MemberId(command.id()))
                        .orElse(null);
        if (member == null)
            throw new NotFoundException("Member not found");

        repository.delete(member);
        return memberMapper.toResponse(member);
    }
}
