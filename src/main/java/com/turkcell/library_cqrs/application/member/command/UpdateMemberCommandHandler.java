package com.turkcell.library_cqrs.application.member.command;

import com.turkcell.library_cqrs.application.member.dto.UpdatedMemberResponse;
import com.turkcell.library_cqrs.application.member.mapper.UpdateMemberMapper;
import com.turkcell.library_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_cqrs.domain.member.model.Member;
import com.turkcell.library_cqrs.domain.member.model.MemberId;
import com.turkcell.library_cqrs.domain.member.policy.MemberEmailUniquePolicy;
import com.turkcell.library_cqrs.domain.member.policy.MemberExistsPolicy;
import com.turkcell.library_cqrs.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

//CommandHandler burası ve CommandHandler interfaceini implemente edecek
@Component
public class UpdateMemberCommandHandler implements CommandHandler<UpdateMemberCommand, UpdatedMemberResponse> {
    private final UpdateMemberMapper updateMemberMapper;
    private final MemberRepository repository;
    private final MemberExistsPolicy memberExistsPolicy;
    private final MemberEmailUniquePolicy memberEmailUniquePolicy;

    public UpdateMemberCommandHandler(UpdateMemberMapper updateMemberMapper, MemberRepository repository, MemberExistsPolicy memberExistsPolicy, MemberEmailUniquePolicy memberEmailUniquePolicy) {
        this.updateMemberMapper = updateMemberMapper;
        this.repository = repository;
        this.memberExistsPolicy = memberExistsPolicy;
        this.memberEmailUniquePolicy = memberEmailUniquePolicy;
    }

    @Override
    public UpdatedMemberResponse handle(UpdateMemberCommand command) {
        if(!memberExistsPolicy.existsMember(new MemberId(command.id()))){
            throw new NotFoundException("Member not found");
        }
        if (!memberEmailUniquePolicy.isUnique(command.email())){
            throw new RuntimeException("Email is not unique");
        }
        //TODO: fix
        //command'ı domain nesnesine cevir
        Member member = updateMemberMapper.toDomain(command);
        //repository ile kaydet
        member = repository.save(member);
        //responsu dön
        return updateMemberMapper.toResponse(member);
    }
}
