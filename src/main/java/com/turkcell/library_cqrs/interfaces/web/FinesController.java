package com.turkcell.library_cqrs.interfaces.web;

import com.turkcell.library_cqrs.application.fine.command.CreateFineCommand;
import com.turkcell.library_cqrs.application.fine.dto.CreateFineResponse;
import com.turkcell.library_cqrs.application.fine.dto.FineResponse;
import com.turkcell.library_cqrs.application.fine.query.GetFineByIdQuery;
import com.turkcell.library_cqrs.application.fine.query.ListFinesQuery;
import com.turkcell.library_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_cqrs.core.cqrs.QueryHandler;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fines")
@Validated
public class FinesController {
    private final CommandHandler<CreateFineCommand, CreateFineResponse> createfineCommandHandler;
    private final QueryHandler<GetFineByIdQuery, FineResponse> getfineByIdQueryHandler;
    private final QueryHandler<ListFinesQuery, List<FineResponse>> listFinesQueryHandler;

    public FinesController(CommandHandler<CreateFineCommand, CreateFineResponse> createfineCommandHandler, QueryHandler<GetFineByIdQuery, FineResponse> getfineByIdQueryHandler, QueryHandler<ListFinesQuery, List<FineResponse>> listFinesQueryHandler) {
        this.createfineCommandHandler = createfineCommandHandler;
        this.getfineByIdQueryHandler = getfineByIdQueryHandler;
        this.listFinesQueryHandler = listFinesQueryHandler;
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CreateFineResponse create(@RequestBody @Valid CreateFineCommand command){
        return createfineCommandHandler.handle(command);
    }

    @GetMapping("/{id}")
    public FineResponse getById(@Valid @PathVariable GetFineByIdQuery query){
        return getfineByIdQueryHandler.handle(query);
    }

    @GetMapping
    public List<FineResponse> getFines(@Valid ListFinesQuery query){
        return listFinesQueryHandler.handle(query);
    }

}
