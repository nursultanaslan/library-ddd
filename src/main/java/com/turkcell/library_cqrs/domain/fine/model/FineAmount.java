package com.turkcell.library_cqrs.domain.fine.model;

import java.math.BigDecimal;
import java.util.Objects;

public record FineAmount(BigDecimal value, String currency) {
    public FineAmount{
        Objects.requireNonNull(value, "Amount cannot be null");
        Objects.requireNonNull(currency, "Currency cannot be null");

        if (value.signum() < 0)
            throw new IllegalArgumentException("Amount must be positive");
        if (currency.isBlank())
            throw new IllegalArgumentException("Currency cannot be blank");
    }

}
