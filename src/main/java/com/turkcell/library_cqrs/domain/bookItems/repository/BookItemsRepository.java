package com.turkcell.library_cqrs.domain.bookItems.repository;

import com.turkcell.library_cqrs.domain.bookItems.model.BookItems;
import com.turkcell.library_cqrs.domain.bookItems.model.BookItemsId;

import java.util.List;

public interface BookItemsRepository {
    BookItems save(BookItems bookItems);
    List<BookItemsId> findById(BookItemsId bookItemsId);
    List<BookItems> findAllPaged(Integer pageIndex, Integer pageSize);
}
