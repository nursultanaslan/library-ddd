package com.turkcell.library_cqrs.application.fine.query;

import com.turkcell.library_cqrs.application.fine.dto.FineResponse;
import com.turkcell.library_cqrs.application.fine.mapper.FineResponseMapper;
import com.turkcell.library_cqrs.core.cqrs.QueryHandler;
import com.turkcell.library_cqrs.domain.fine.repository.FineRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListFinesQueryHandler implements QueryHandler<ListFinesQuery, List<FineResponse>> {
    private final FineRepository fineRepository;
    private final FineResponseMapper fineResponseMapper;

    public ListFinesQueryHandler(FineRepository fineRepository, FineResponseMapper fineResponseMapper) {
        this.fineRepository = fineRepository;
        this.fineResponseMapper = fineResponseMapper;
    }

    @Override
    public List<FineResponse> handle(ListFinesQuery query) {
        return fineRepository
                .findAllPaged(query.pageIndex(), query.pageSize())
                .stream()
                .map(fineResponseMapper::toResponse)
                .toList();
    }
}
