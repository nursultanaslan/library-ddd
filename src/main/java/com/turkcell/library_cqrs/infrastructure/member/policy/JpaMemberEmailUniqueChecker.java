package com.turkcell.library_cqrs.infrastructure.member.policy;


import com.turkcell.library_cqrs.domain.member.model.Email;
import com.turkcell.library_cqrs.domain.member.policy.MemberEmailUniquePolicy;
import com.turkcell.library_cqrs.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Component;

@Component
public class JpaMemberEmailUniqueChecker implements MemberEmailUniquePolicy {
    private final MemberRepository repository;

    public JpaMemberEmailUniqueChecker(MemberRepository repository) {
        this.repository = repository;
    }


    @Override
    public boolean isUnique(String email) {
        return !repository.existsByEmail(new Email(email));
    }
}
