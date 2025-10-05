package com.turkcell.library_cqrs.application.book.dto;

import com.turkcell.library_cqrs.domain.book.model.Author;

import java.util.UUID;

public record CreateBookResponse(UUID id,
                                String title,
                                String author,
                                String author1,
                                String publisher,
                                 int totalPage) {

}
