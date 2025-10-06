package com.turkcell.library_cqrs.application.fine.command;

import com.turkcell.library_cqrs.application.fine.dto.CreateFineResponse;
import com.turkcell.library_cqrs.application.fine.mapper.CreateFineMapper;
import com.turkcell.library_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_cqrs.domain.fine.model.Fine;
import com.turkcell.library_cqrs.domain.fine.repository.FineRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateFineCommandHandler implements CommandHandler<CreateFineCommand, CreateFineResponse> {
    private final CreateFineMapper fineMapper;
    private final FineRepository repository;

    public CreateFineCommandHandler(CreateFineMapper fineMapper, FineRepository repository) {
        this.fineMapper = fineMapper;
        this.repository = repository;
    }

    @Override
    public CreateFineResponse handle(CreateFineCommand command) {
        //commandı fine domainine donustur
        Fine fine = fineMapper.toDomain(command);
        fine = repository.save(fine);
        return fineMapper.toResponse(fine);
    }
}
