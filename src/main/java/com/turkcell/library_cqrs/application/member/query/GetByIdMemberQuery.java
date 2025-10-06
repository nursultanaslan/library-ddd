package com.turkcell.library_cqrs.application.member.query;


import com.turkcell.library_cqrs.application.member.dto.GetByIdMemberResponse;
import com.turkcell.library_cqrs.core.cqrs.Query;
import com.turkcell.library_cqrs.domain.member.model.MemberId;
import jakarta.validation.constraints.NotNull;

public record GetByIdMemberQuery(@NotNull MemberId id) implements Query<GetByIdMemberResponse> {


}
