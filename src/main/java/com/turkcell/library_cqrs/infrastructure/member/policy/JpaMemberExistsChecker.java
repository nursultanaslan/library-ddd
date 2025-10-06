package com.turkcell.library_cqrs.infrastructure.member.policy;

import com.turkcell.library_cqrs.domain.member.model.MemberId;
import com.turkcell.library_cqrs.domain.member.policy.MemberExistsPolicy;
import com.turkcell.library_cqrs.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Component;


@Component
public class JpaMemberExistsChecker implements MemberExistsPolicy {
    private final MemberRepository repository;

    public JpaMemberExistsChecker(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsMember(MemberId memberId) {
        return repository.existsByMemberId(memberId);
    }
}
