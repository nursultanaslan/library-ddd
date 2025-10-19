package com.turkcell.library_cqrs.persistence.category.repository;

import com.turkcell.library_cqrs.persistence.category.entity.JpaCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataCategoryRepository extends JpaRepository<JpaCategoryEntity, UUID> {
}
