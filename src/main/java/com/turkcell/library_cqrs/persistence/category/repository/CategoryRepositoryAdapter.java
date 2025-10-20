package com.turkcell.library_cqrs.persistence.category.repository;

import com.turkcell.library_cqrs.domain.category.model.Category;
import com.turkcell.library_cqrs.domain.category.model.CategoryId;
import com.turkcell.library_cqrs.domain.category.repository.CategoryRepository;
import com.turkcell.library_cqrs.persistence.category.entity.JpaCategoryEntity;
import com.turkcell.library_cqrs.persistence.category.mapper.CategoryEntityMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepositoryAdapter implements CategoryRepository {
    private final SpringDataCategoryRepository repository;
    private final CategoryEntityMapper categoryMapper;

    public CategoryRepositoryAdapter(SpringDataCategoryRepository repository, CategoryEntityMapper categoryMapper) {
        this.repository = repository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Category save(Category category) {
        JpaCategoryEntity entity = categoryMapper.toEntity(category);
        entity = repository.save(entity);
        return categoryMapper.toDomain(entity);
    }

    @Override
    public List<Category> findAll() {
        return repository
                .findAll()
                .stream()
                .map(categoryMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Category> findById(CategoryId categoryId) {
        return repository
                .findById(categoryId.value())
                .map(categoryMapper::toDomain);

    }

    @Override
    public void delete(CategoryId categoryId) {
        repository.deleteById(categoryId.value());
    }

    @Override
    public List<Category> findAllPaged(Integer pageIndex, Integer pageSize) {
        return repository
                .findAll(PageRequest.of(pageIndex, pageSize))
                .stream()
                .map(categoryMapper::toDomain)
                .toList();
    }
}
