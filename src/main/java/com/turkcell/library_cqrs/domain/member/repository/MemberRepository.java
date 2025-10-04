package com.turkcell.library_cqrs.domain.member.repository;

import com.turkcell.library_cqrs.domain.member.model.Member;
import com.turkcell.library_cqrs.domain.member.model.MemberId;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(MemberId memberId);
    List<Member> findAll();
    List<Member> findAllPaged(Integer pageIndex, Integer pageSize);
    void delete(MemberId memberId);
}
