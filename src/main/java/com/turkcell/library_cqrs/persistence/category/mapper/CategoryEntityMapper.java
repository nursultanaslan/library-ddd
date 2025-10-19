package com.turkcell.library_cqrs.persistence.category.mapper;

import com.turkcell.library_cqrs.domain.category.model.Category;
import com.turkcell.library_cqrs.domain.category.model.CategoryId;
import com.turkcell.library_cqrs.persistence.category.entity.JpaCategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryEntityMapper {

    public JpaCategoryEntity toEntity(Category category){
        JpaCategoryEntity entity = new JpaCategoryEntity();
        entity.setId(category.id().value());
        entity.setName(category.name());
        return entity;
    }

    public Category toDomain(JpaCategoryEntity entity){
        return Category.rehydrate(
                new CategoryId(entity.id()),
                entity.name()
        );
    }
}
