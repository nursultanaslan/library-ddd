package com.turkcell.library_cqrs.application.member.dto;

import com.turkcell.library_cqrs.domain.member.model.Username;

import java.util.UUID;

//Kullanıcı bilgilerini güncelledikten sonra ona ne dönecegim?
public record UpdatedMemberResponse(
        UUID id, String firstName, String lastName, String username
) {
}
