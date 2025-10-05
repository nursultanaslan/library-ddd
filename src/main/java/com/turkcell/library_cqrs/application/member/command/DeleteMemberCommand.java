package com.turkcell.library_cqrs.application.member.command;

import com.turkcell.library_cqrs.application.member.dto.DeletedMemberResponse;
import com.turkcell.library_cqrs.core.cqrs.Command;

import java.util.UUID;

public record DeleteMemberCommand(UUID id) implements Command<DeletedMemberResponse> {
}
