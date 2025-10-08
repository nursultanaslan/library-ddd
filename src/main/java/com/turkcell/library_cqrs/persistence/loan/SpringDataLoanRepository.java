package com.turkcell.library_cqrs.persistence.loan;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataLoanRepository extends JpaRepository<JpaLoanEntity, UUID> {
}
