package com.turkcell.library_cqrs.domain.member.policy;


public interface MemberEmailUniquePolicy {
    boolean isUnique(String email);
}
