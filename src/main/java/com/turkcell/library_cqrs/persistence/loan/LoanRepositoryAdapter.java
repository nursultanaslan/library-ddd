package com.turkcell.library_cqrs.persistence.loan;

import com.turkcell.library_cqrs.domain.loan.model.Loan;
import com.turkcell.library_cqrs.domain.loan.model.LoanId;
import com.turkcell.library_cqrs.domain.loan.repository.LoanRepository;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public class LoanRepositoryAdapter implements LoanRepository {

    private final SpringDataLoanRepository springDataLoanRepository;
    private final LoanEntityMapper loanEntityMapper;

    public LoanRepositoryAdapter(SpringDataLoanRepository springDataLoanRepository, LoanEntityMapper loanEntityMapper) {
        this.springDataLoanRepository = springDataLoanRepository;
        this.loanEntityMapper = loanEntityMapper;
    }

    @Override
    public Loan save(Loan loan) {
        JpaLoanEntity entity=loanEntityMapper.toEntity(loan);
        entity=springDataLoanRepository.save(entity);
        return  loanEntityMapper.toDomain(entity);
    }

    @Override
    public Optional<Loan> findById(LoanId loanId) {
        return springDataLoanRepository
                .findById(loanId.value())
                .map(loanEntityMapper::toDomain);
    }

    @Override
    public List<Loan> findAll() {
        return springDataLoanRepository
                .findAll()
                .stream()
                .map(loanEntityMapper::toDomain)  // method reference
                .toList();
    }

    @Override
    public List<Loan> findAllPaged(Integer pageIndex, Integer pageSize) {
        return springDataLoanRepository
                .findAll(PageRequest.of(pageIndex, pageSize))
                .stream()
                .map(loanEntityMapper::toDomain)
                .toList();
    }

    @Override
    public void delete(LoanId loanId) {
        springDataLoanRepository.deleteById(loanId.value());
    }
}
