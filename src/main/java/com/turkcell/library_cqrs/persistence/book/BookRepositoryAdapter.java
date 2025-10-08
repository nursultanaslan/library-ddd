package com.turkcell.library_cqrs.persistence.book;

import com.turkcell.library_cqrs.domain.book.model.Book;
import com.turkcell.library_cqrs.domain.book.model.BookId;
import com.turkcell.library_cqrs.domain.book.repository.BookRepository;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public class BookRepositoryAdapter implements BookRepository {

    private final SpringDataBookRepository springDataBookRepository;
    private final BookEntityMapper bookEntityMapper;

    public BookRepositoryAdapter(SpringDataBookRepository springDataBookRepository, BookEntityMapper bookEntityMapper) {
        this.springDataBookRepository = springDataBookRepository;
        this.bookEntityMapper = bookEntityMapper;
    }

    @Override
    public Book save(Book book) {
        JpaBookEntity entity=bookEntityMapper.toEntity(book);
        entity=springDataBookRepository.save(entity);
        return bookEntityMapper.toDomain(entity);
    }

    @Override
    public Optional<Book> findById(BookId bookId) {
       return springDataBookRepository
               .findById(bookId.value())
               .map(bookEntityMapper::toDomain);
    }

    @Override
    public List<Book> findAll() {
        return springDataBookRepository
                .findAll()
                .stream()
                .map(bookEntityMapper::toDomain)  // method reference
                .toList();
    }

    @Override
    public List<Book> findAllPaged(Integer pageIndex, Integer pageSize) {
        return springDataBookRepository
                .findAll(PageRequest.of(pageIndex,pageSize))
                .stream()
                .map(bookEntityMapper::toDomain)
                .toList();
    }

    @Override
    public void delete(BookId bookId) {
        springDataBookRepository.deleteById(bookId.value());
    }
}
