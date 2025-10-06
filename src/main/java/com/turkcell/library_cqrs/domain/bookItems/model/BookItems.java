package com.turkcell.library_cqrs.domain.bookItems.model;

import java.util.Objects;

public class BookItems {

    private final BookItemsId id;
    private BookStatus bookStatus;

    public BookItems(BookItemsId id, BookStatus bookStatus) {
        this.id = id;
        this.bookStatus = bookStatus;
    }

    private static BookItems create(BookStatus bookStatus){
        Objects.requireNonNull(bookStatus);
        return new BookItems(BookItemsId.generate(),
                bookStatus);
    }

    public static BookItems rehydrate(BookItemsId bookItemsId,BookStatus bookStatus){
        return  new BookItems(bookItemsId,bookStatus);
    }

    public void markAsLoaned() {
        if (this.bookStatus != BookStatus.ACTIVE) {
            throw new IllegalStateException("Book cannot be loaned because it is not available.");
        }
        this.bookStatus = BookStatus.LOANED;
    }

    public void markAsReturned() {
        if (this.bookStatus != BookStatus.LOANED) {
            throw new IllegalStateException("Book cannot be returned because it was not loaned.");
        }
        this.bookStatus = BookStatus.ACTIVE;
    }

    public void markAsLost() {
        if (this.bookStatus == BookStatus.LOST) {
            throw new IllegalStateException("Book is already marked as lost.");
        }
        this.bookStatus = BookStatus.LOST;
    }

    public void markAsDamaged() {
        if (this.bookStatus == BookStatus.DAMAGED) {
            throw new IllegalStateException("Book is already marked as damaged.");
        }
        this.bookStatus = BookStatus.DAMAGED;
    }

    public BookItemsId getId() {
        return id;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }
}
