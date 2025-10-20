package com.turkcell.library_cqrs.application.fine.query;

import com.turkcell.library_cqrs.application.fine.dto.FineResponse;
import com.turkcell.library_cqrs.application.fine.mapper.FineResponseMapper;
import com.turkcell.library_cqrs.core.cqrs.QueryHandler;
import com.turkcell.library_cqrs.domain.fine.model.FineId;
import com.turkcell.library_cqrs.domain.fine.repository.FineRepository;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

@Component
public class GetFineByIdQueryHandler implements QueryHandler<GetFineByIdQuery, FineResponse> {
    private final FineRepository fineRepository;
    private final FineResponseMapper fineResponseMapper;

    public GetFineByIdQueryHandler(FineRepository fineRepository, FineResponseMapper fineResponseMapper) {
        this.fineRepository = fineRepository;
        this.fineResponseMapper = fineResponseMapper;
    }

    @Override
    public FineResponse handle(GetFineByIdQuery query) {
        return fineRepository
                .findById(new FineId(query.id()))
                .stream()
                .map(fineResponseMapper::toResponse)
                .findAny()
                .orElseThrow(() -> new NotFoundException("Fine not found"));
    }
}
