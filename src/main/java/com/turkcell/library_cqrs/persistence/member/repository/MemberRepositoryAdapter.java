package com.turkcell.library_cqrs.persistence.member.repository;

import com.turkcell.library_cqrs.domain.member.model.Email;
import com.turkcell.library_cqrs.domain.member.model.Member;
import com.turkcell.library_cqrs.domain.member.model.MemberId;
import com.turkcell.library_cqrs.domain.member.repository.MemberRepository;
import com.turkcell.library_cqrs.persistence.member.entity.JpaMemberEntity;
import com.turkcell.library_cqrs.persistence.member.mapper.MemberEntityMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//İçteki(domaindeki) interface(memberRepo) bağımlı hale gelir ve onu uygular. (bağımsızlık ilkesi)
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
    public void deleteById(MemberId memberId) {
        repository.deleteById(memberId.value());
    }

    @Override
    public void delete(Member member) {
        JpaMemberEntity entity = memberEntityMapper.toEntity(member);
        repository.delete(entity);
    }

    @Override
    public boolean existsByMemberId(MemberId memberId) {
        return repository.existsByMemberId(memberId.value());
    }

    @Override
    public boolean existsByEmail(Email email) {
        return repository.existsByEmail(email.value());
    }


}
