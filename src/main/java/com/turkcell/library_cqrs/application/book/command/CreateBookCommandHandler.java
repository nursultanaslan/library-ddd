package com.turkcell.library_cqrs.application.book.command;

import com.turkcell.library_cqrs.application.book.dto.CreateBookResponse;
import com.turkcell.library_cqrs.application.book.mapper.CreateBookMapper;
import com.turkcell.library_cqrs.core.cqrs.CommandHandler;
import com.turkcell.library_cqrs.domain.book.model.Book;
import com.turkcell.library_cqrs.domain.book.repository.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateBookCommandHandler implements CommandHandler<CreateBookCommand, CreateBookResponse> {

    private final BookRepository bookRepository;
    private final CreateBookMapper createBookMapper;

    public CreateBookCommandHandler(BookRepository bookRepository,CreateBookMapper createBookMapper){
        this.bookRepository=bookRepository;
        this.createBookMapper=createBookMapper;
    }

    @Override
    public CreateBookResponse handle(CreateBookCommand command){
        Book book=createBookMapper.toDomain(command);
        book=bookRepository.save(book);
        return createBookMapper.toResponse(book);
    }
}
