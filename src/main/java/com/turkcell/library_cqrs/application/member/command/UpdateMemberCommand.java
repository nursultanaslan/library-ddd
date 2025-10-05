package com.turkcell.library_cqrs.application.member.command;

import com.turkcell.library_cqrs.application.member.dto.UpdatedMemberResponse;
import com.turkcell.library_cqrs.core.cqrs.Command;
import jakarta.validation.constraints.*;

import java.util.UUID;

//Bu bir command ve Command interface'ini implemente eder.
//ve bu command bir Response geri dönecek
//Record tanımladık cünkü kullanıcıdan gelen istegin herhangi bir yerde degişmesini istemiyoruz
//Dto'da eskiden yaptıgımız gibi değerler üzerinde Validationlar yapabiliriz.
public record UpdateMemberCommand(
    @Positive UUID id,
    @NotBlank @Size(min = 3, max = 50) String firstName,
    @NotBlank @Size(min = 3, max = 50) String lastName,
    @NotBlank @Size(min = 3, max = 20) String username,
    @NotBlank String password,
    @NotBlank @Email String email,
    @NotBlank @Pattern(regexp = "^5[0-9]{9}$") String phone
) implements Command<UpdatedMemberResponse> {

}
