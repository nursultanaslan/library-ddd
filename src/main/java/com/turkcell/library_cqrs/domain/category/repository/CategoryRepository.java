package com.turkcell.library_cqrs.domain.category.repository;

import com.turkcell.library_cqrs.domain.category.model.Category;
import com.turkcell.library_cqrs.domain.category.model.CategoryId;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {

    Category save(Category category);
    List<Category> findAll();
    Optional<Category> findById(CategoryId categoryId);
    void deleteById(CategoryId categoryId);
    void delete(Category category);
    List<Category> findAllPaged(Integer pageIndex, Integer pageSize);
}
