package com.turkcell.library_cqrs.domain.bookItems.model;

public enum BookStatus {
    ACTIVE,  //The book is in the library and can be borrowed.
    LOANED,  //The book is borrowed, the member
    LOST,
    DAMAGED;

    public static BookStatus getDefault(){
        return ACTIVE;
    }
}
