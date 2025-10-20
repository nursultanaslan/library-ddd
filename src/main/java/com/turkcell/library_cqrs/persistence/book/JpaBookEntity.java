package com.turkcell.library_cqrs.persistence.book;

import com.turkcell.library_cqrs.persistence.category.entity.JpaCategoryEntity;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="products")
public class JpaBookEntity {

    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(name = "title",nullable = false,length = 255)
    String title;

    @Column(name = "author",nullable = false,length = 255)
    String authorFulName;

    @Column(name = "isbn",nullable = false)
    String isbn;

    @Column(name = "totalPage",nullable = false)
    int totalPage;

    @Column(name = "publisher",nullable = false)
    private String publisher;

    @Column(name = "imageUrl", nullable = false)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private JpaCategoryEntity category;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorFulName() {
        return authorFulName;
    }

    public void setAuthorFulName(String authorFulName) {
        this.authorFulName = authorFulName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public JpaCategoryEntity category() {
        return category;
    }

    public void setCategory(JpaCategoryEntity category) {
        this.category = category;
    }
}
