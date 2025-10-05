package com.turkcell.library_cqrs.application.book.command;

import com.turkcell.library_cqrs.application.book.dto.CreateBookResponse;
import com.turkcell.library_cqrs.core.cqrs.Command;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

public record CreateBookCommand(
        @NotBlank @Size(min=3,max = 255) String title,
        @NotBlank @Size(min=3,max = 255) String firstName,
        @NotBlank @Size(min=3,max = 255) String lastName,
        @Length()String isbn,
        @Size(min=1)Integer totalPage,
        @URL String imageUrl,
        @NotBlank String publisher
)implements Command<CreateBookResponse> {
}
