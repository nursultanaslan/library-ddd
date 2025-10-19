package com.turkcell.library_cqrs.application.member.query;


import com.turkcell.library_cqrs.application.member.dto.GetByIdMemberResponse;
import com.turkcell.library_cqrs.core.cqrs.Query;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record GetByIdMemberQuery(@NotNull UUID id) implements Query<GetByIdMemberResponse> {


}
