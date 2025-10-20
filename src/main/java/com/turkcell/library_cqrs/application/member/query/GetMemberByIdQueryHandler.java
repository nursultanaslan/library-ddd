package com.turkcell.library_cqrs.application.member.query;

import com.turkcell.library_cqrs.application.member.dto.GetByIdMemberResponse;
import com.turkcell.library_cqrs.application.member.mapper.GetByIdMemberMapper;
import com.turkcell.library_cqrs.core.cqrs.QueryHandler;
import com.turkcell.library_cqrs.domain.member.model.MemberId;
import com.turkcell.library_cqrs.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

@Component
public class GetMemberByIdQueryHandler implements QueryHandler<GetByIdMemberQuery, GetByIdMemberResponse> {
    private final MemberRepository memberRepository;
    private final GetByIdMemberMapper memberMapper;

    public GetMemberByIdQueryHandler(MemberRepository memberRepository, GetByIdMemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }

    @Override
    public GetByIdMemberResponse handle(GetByIdMemberQuery query) {
        return memberRepository
                .findById(new MemberId(query.id()))
                .stream()
                .map(memberMapper::toResponse)
                .findAny()
                .orElseThrow(()-> new NotFoundException("Member not found"));

    }
}
