package com.turkcell.library_cqrs.application.book.mapper;

import com.turkcell.library_cqrs.application.book.command.CreateBookCommand;
import com.turkcell.library_cqrs.application.book.dto.CreateBookResponse;
import com.turkcell.library_cqrs.domain.book.model.Author;
import com.turkcell.library_cqrs.domain.book.model.Book;

public class CreateBookMapper {
    public Book toDomain(CreateBookCommand command){
        return Book.create(
                command.title(),
                new Author(command.firstName(),command.lastName()),
                command.isbn(),
                command.totalPage(),
                command.publisher(),
                command.imageUrl()
        );
    }

    public CreateBookResponse toResponse(Book book){
        return new CreateBookResponse(
                book.getId().value(),
                book.getTitle(),
                book.getAuthor().firstname(),
                book.getAuthor().lastname(),
                book.getPublisher(),
                book.getTotalPage()
        );
    }
}
