package com.turkcell.library_cqrs.persistence.member.repository;

import com.turkcell.library_cqrs.persistence.member.entity.JpaMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataMemberRepository extends JpaRepository<JpaMemberEntity, UUID> {
}
