package com.turkcell.library_cqrs.domain.fine.repository;

import com.turkcell.library_cqrs.domain.fine.model.Fine;
import com.turkcell.library_cqrs.domain.fine.model.FineId;

import java.util.List;
import java.util.Optional;

public interface FineRepository {
    Fine save(Fine fine);
    Optional<Fine> findById(FineId fineId);
    List<Fine> findAll();
    void delete(FineId fineId);
    List<Fine> findAllPaged(Integer pageIndex, Integer pageSize);
}
