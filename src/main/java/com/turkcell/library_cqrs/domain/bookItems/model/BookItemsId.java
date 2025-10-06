package com.turkcell.library_cqrs.domain.bookItems.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public record BookItemsId(UUID value) implements Serializable {

    public BookItemsId{
        Objects.requireNonNull(value,"Value for BookItemsId cannot be null");
    }

    public static BookItemsId generate(){
        return new BookItemsId(UUID.randomUUID());
    }
}
