package com.turkcell.library_cqrs.domain.member.policy;

import com.turkcell.library_cqrs.domain.member.model.MemberId;


public interface MemberExistsPolicy {
    boolean existsMember(MemberId memberId);
}
