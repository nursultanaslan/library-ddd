package com.turkcell.library_cqrs.interfaces.web;

import com.turkcell.library_cqrs.application.member.command.DeleteMemberCommand;
import com.turkcell.library_cqrs.application.member.command.UpdateMemberCommand;
import com.turkcell.library_cqrs.application.member.dto.DeletedMemberResponse;
import com.turkcell.library_cqrs.application.member.dto.GetByIdMemberResponse;
import com.turkcell.library_cqrs.application.member.dto.UpdatedMemberResponse;
import com.turkcell.library_cqrs.application.member.query.GetByIdMemberQuery;
import com.turkcell.library_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_cqrs.core.cqrs.QueryHandler;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/members")
@Validated
public class MembersController {

    private final QueryHandler<GetByIdMemberQuery, GetByIdMemberResponse> getByIdQueryHandler;
    private final CommandHandler<UpdateMemberCommand, UpdatedMemberResponse> updateMemberCommandHandler;
    private final CommandHandler<DeleteMemberCommand, DeletedMemberResponse> deleteCommandHandler;

    public MembersController(QueryHandler<GetByIdMemberQuery, GetByIdMemberResponse> getByIdQueryHandler, CommandHandler<UpdateMemberCommand, UpdatedMemberResponse> updateMemberCommandHandler, CommandHandler<DeleteMemberCommand, DeletedMemberResponse> deleteCommandHandler) {
        this.getByIdQueryHandler = getByIdQueryHandler;
        this.updateMemberCommandHandler = updateMemberCommandHandler;
        this.deleteCommandHandler = deleteCommandHandler;
    }

    @GetMapping("/{id}")
    public GetByIdMemberResponse getById(@Valid GetByIdMemberQuery query){
        return getByIdQueryHandler.handle(query);
    }

    @PutMapping()
    public UpdatedMemberResponse update(@Valid @RequestBody UpdateMemberCommand command){
        return updateMemberCommandHandler.handle(command);
    }

    @DeleteMapping
    public DeletedMemberResponse delete(DeleteMemberCommand command){
        return deleteCommandHandler.handle(command);
    }
}
