package com.turkcell.library_cqrs.domain.book.model;

import java.util.Objects;

public record Author(String firstname, String lastname){
    public Author{
        Objects.requireNonNull(firstname);
        Objects.requireNonNull(lastname);

        if (firstname.isBlank())
            throw new IllegalArgumentException("First name cannot be blank");

        if (lastname.isBlank())
            throw new IllegalArgumentException("Last name cannot be blank");

    }
}
