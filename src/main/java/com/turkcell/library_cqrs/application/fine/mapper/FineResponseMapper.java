package com.turkcell.library_cqrs.application.fine.mapper;

import com.turkcell.library_cqrs.application.fine.dto.FineResponse;
import com.turkcell.library_cqrs.domain.fine.model.Fine;
import org.springframework.stereotype.Component;

@Component
public class FineResponseMapper {

    public FineResponse toResponse(Fine fine){
        return new FineResponse(
                fine.id().value(),
                fine.amount().value(),
                fine.amount().currency(),
                fine.fineDate(),
                fine.isPaid()
        );
    }
}
