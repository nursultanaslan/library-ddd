package com.turkcell.library_cqrs.domain.fine.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public record FineId(UUID value) implements Serializable {
    public FineId{
        Objects.requireNonNull(value, "Value for Fine Id cannot be null");
    }

    public static FineId generate(){
        return new FineId(UUID.randomUUID());
    }
}
