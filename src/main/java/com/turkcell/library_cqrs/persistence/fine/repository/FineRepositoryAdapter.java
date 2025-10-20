package com.turkcell.library_cqrs.persistence.fine.repository;

import com.turkcell.library_cqrs.domain.fine.model.Fine;
import com.turkcell.library_cqrs.domain.fine.model.FineId;
import com.turkcell.library_cqrs.domain.fine.repository.FineRepository;
import com.turkcell.library_cqrs.persistence.fine.entity.JpaFineEntity;
import com.turkcell.library_cqrs.persistence.fine.mapper.FineEntityMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FineRepositoryAdapter implements FineRepository {
    private final FineEntityMapper fineEntityMapper;
    private final SpringDataFineRepository repository;

    public FineRepositoryAdapter(FineEntityMapper fineEntityMapper, SpringDataFineRepository repository) {
        this.fineEntityMapper = fineEntityMapper;
        this.repository = repository;
    }


    @Override
    public Fine save(Fine fine) {
        JpaFineEntity entity = fineEntityMapper.toEntity(fine);
        entity = repository.save(entity);
        return fineEntityMapper.toDomain(entity);
    }

    @Override
    public Optional<Fine> findById(FineId fineId) {
        return repository
                .findById(fineId.value())
                .map(fineEntityMapper::toDomain);
    }

    @Override
    public List<Fine> findAll() {
        return repository
                .findAll()
                .stream()
                .map(fineEntityMapper::toDomain)
                .toList();
    }

    @Override
    public void delete(FineId fineId) {
        repository.deleteById(fineId.value());
    }

    @Override
    public List<Fine> findAllPaged(Integer pageIndex, Integer pageSize) {
        return repository
                .findAll(PageRequest.of(pageIndex, pageSize))
                .stream()
                .map(fineEntityMapper::toDomain)
                .toList();
    }
}
