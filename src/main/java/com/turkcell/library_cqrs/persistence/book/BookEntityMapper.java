package com.turkcell.library_cqrs.persistence.book;

import com.turkcell.library_cqrs.domain.book.model.Author;
import com.turkcell.library_cqrs.domain.book.model.Book;
import com.turkcell.library_cqrs.domain.book.model.BookId;
import com.turkcell.library_cqrs.domain.category.model.CategoryId;
import com.turkcell.library_cqrs.persistence.category.entity.JpaCategoryEntity;

public class BookEntityMapper {

    public  JpaBookEntity toEntity(Book book){
        JpaBookEntity bookEntity=new JpaBookEntity();
        bookEntity.setId(book.getId().value());
        bookEntity.setTitle(book.getTitle());
        bookEntity.setAuthorFulName(book.getAuthor().firstname());
        bookEntity.setAuthorFulName(book.getAuthor().lastname());
        bookEntity.setIsbn(book.getIsbn());
        bookEntity.setTotalPage(book.getTotalPage());
        bookEntity.setImageUrl(book.getImageUrl());
        bookEntity.setPublisher(book.getPublisher());
        bookEntity.setCategory(new JpaCategoryEntity(book.getCategoryId().value()));
        return bookEntity;
    }

    public Book toDomain(JpaBookEntity book){
        return Book.rehydrate(
                new BookId(book.getId()),
                book.getTitle(),
                new Author(book.getAuthorFulName(), book.getAuthorFulName()),
                book.getIsbn(),
                book.getTotalPage(),
                book.getPublisher(),
                book.getImageUrl(),
                new CategoryId(book.getId())
        );
    }
}
