package com.turkcell.library_cqrs.persistence.category.entity;

import com.turkcell.library_cqrs.persistence.book.JpaBookEntity;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "categories")
public class JpaCategoryEntity {

    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<JpaBookEntity> books;

    public JpaCategoryEntity() {
    }

    public JpaCategoryEntity(UUID id) {
        this.id = id;
    }

    public UUID id() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<JpaBookEntity> books() {
        return books;
    }

    public void setBooks(List<JpaBookEntity> books) {
        this.books = books;
    }
}
