package com.turkcell.library_cqrs.application.member.command;

import com.turkcell.library_cqrs.application.member.dto.UpdatedMemberResponse;
import com.turkcell.library_cqrs.application.member.mapper.UpdateMemberMapper;
import com.turkcell.library_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_cqrs.domain.member.model.Member;
import com.turkcell.library_cqrs.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Component;

//CommandHandler burası ve CommandHandler interfaceini implemente edecek
@Component
public class UpdateMemberCommandHandler implements CommandHandler<UpdateMemberCommand, UpdatedMemberResponse> {
    private final UpdateMemberMapper updateMemberMapper;
    private final MemberRepository repository;

    public UpdateMemberCommandHandler(UpdateMemberMapper updateMemberMapper, MemberRepository repository) {
        this.updateMemberMapper = updateMemberMapper;
        this.repository = repository;
    }

    @Override
    public UpdatedMemberResponse handle(UpdateMemberCommand command) {
        //command'ı domain nesnesine cevir
        Member member = updateMemberMapper.toDomain(command);
        //repository ile kaydet
        member = repository.save(member);
        //responsu dön
        return updateMemberMapper.toResponse(member);
    }
}
