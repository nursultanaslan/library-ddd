package com.turkcell.library_cqrs.application.fine.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record FineResponse(
        UUID id,
        BigDecimal amount,
        String currency,
        LocalDate fineDate,
        Boolean isPaid
) {
}
