package com.turkcell.library_cqrs.application.member.dto;


import java.util.UUID;

public record GetByIdMemberResponse(UUID id, String firstName, String lastName, String username) {
}
