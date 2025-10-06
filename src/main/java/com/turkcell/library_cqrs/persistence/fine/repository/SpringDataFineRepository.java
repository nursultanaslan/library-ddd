package com.turkcell.library_cqrs.persistence.fine.repository;

import com.turkcell.library_cqrs.persistence.fine.entity.JpaFineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataFineRepository extends JpaRepository<JpaFineEntity, UUID> {
}
