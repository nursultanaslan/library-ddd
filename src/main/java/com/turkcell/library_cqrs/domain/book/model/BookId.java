package com.turkcell.library_cqrs.domain.book.model;

import java.util.UUID;

import java.io.Serializable;
import java.util.Objects;

public record BookId(UUID value) implements Serializable {
    public BookId{
        Objects.requireNonNull(value,"Value for BookId cannot be null");
    }

    // Fabrika metodu
    // Nesnenin kendi içinde kendi oluşturulma mekanizmasını yazması
    public static BookId generate(){
        return new BookId(UUID.randomUUID());
    }
}