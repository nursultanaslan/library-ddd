package com.turkcell.library_cqrs.domain.book.model;


import java.util.Objects;

public class Book {

    private final BookId id;
    private String title;
    private Author author;
    private String isbn;
    private Integer totalPage;
    private String publisher;
    private String imageUrl;

    private Book(BookId id, String title, Author author, String isbn, Integer totalPage, String publisher,String imageUrl) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.totalPage = totalPage;
        this.publisher = publisher;
        this.imageUrl=imageUrl;
    }

    public static Book create(String title,Author author,String isbn, Integer totalPage, String publisher,String imageUrl){
        validateTitle(title);
        Objects.requireNonNull(author,"Author cannot be null");
        validateIsbn(isbn);
        validateTotalPage(totalPage);
        validatePublisher(publisher);
        validateImageUrl(imageUrl);

        return new Book(BookId.generate(),title,author,isbn,totalPage,publisher,imageUrl);
    }

    public static Book rehydrate(BookId id, String title, Author author, String isbn, Integer totalPage, String publisher, String imageUrl) {
        return new Book(id, title, author, isbn, totalPage, publisher, imageUrl);
    }

    // İş yapan davranışlar
    public void renameTitle(String newTitle){
        validateTitle(newTitle);
        this.title = newTitle;
    }

    public void changePublisher(String newPublisher){
        validatePublisher(newPublisher);
        this.publisher = newPublisher;
    }

    public void updateImageUrl(String newUrl){
        validateImageUrl(newUrl);
        this.imageUrl = newUrl;
    }

    public void assignAuthor(Author newAuthor){
        Objects.requireNonNull(newAuthor, "Author cannot be null");
        this.author = newAuthor;
    }

    private static void validateTitle(String title) {
        if (title.isEmpty())
            throw new IllegalArgumentException("Title cannot be null");
    }

    private static void validateIsbn(String isbn){
        if (isbn.isEmpty()){
            throw new IllegalArgumentException("Isbn cannot be null");
        }
    }

    private static void validateTotalPage(Integer totalPage){
        if (totalPage==null||totalPage<=0)
            throw new IllegalArgumentException("Total page cannot be negative or null");
    }

    private static void validatePublisher(String publisher){
        if (publisher.isEmpty())
            throw new IllegalArgumentException("Publisher cannot be null");
    }

    private static void validateImageUrl(String imageUrl){
        if (imageUrl == null || imageUrl.isEmpty())
            throw new IllegalArgumentException("Image url cannot be null or empty");
    }

    public BookId getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
