package com.turkcell.library_cqrs.persistence.member.repository;

import com.turkcell.library_cqrs.domain.member.model.Member;
import com.turkcell.library_cqrs.domain.member.model.MemberId;
import com.turkcell.library_cqrs.domain.member.repository.MemberRepository;
import com.turkcell.library_cqrs.persistence.member.entity.JpaMemberEntity;
import com.turkcell.library_cqrs.persistence.member.mapper.MemberEntityMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepositoryAdapter implements MemberRepository {
    private final SpringDataMemberRepository repository;
    private final MemberEntityMapper memberEntityMapper;

    public MemberRepositoryAdapter(SpringDataMemberRepository repository, MemberEntityMapper memberEntityMapper) {
        this.repository = repository;
        this.memberEntityMapper = memberEntityMapper;
    }


    @Override
    public Member save(Member member) {
        JpaMemberEntity entity = memberEntityMapper.toEntity(member);
        entity = repository.save(entity);
        return memberEntityMapper.toDomain(entity);
    }

    @Override
    public Optional<Member> findById(MemberId memberId) {
        return repository
                .findById(memberId.value())
                .map(memberEntityMapper::toDomain);
    }

    @Override
    public List<Member> findAll() {
        return repository
                .findAll()
                .stream()
                .map(memberEntityMapper::toDomain)
                .toList();
    }

    @Override
    public List<Member> findAllPaged(Integer pageIndex, Integer pageSize) {
        return repository
                .findAll(PageRequest.of(pageIndex, pageSize))
                .stream()
                .map(memberEntityMapper::toDomain)
                .toList();
    }

    @Override
    public void delete(MemberId memberId) {
        repository.deleteById(memberId.value());
    }
}
