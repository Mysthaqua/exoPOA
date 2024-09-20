package tibo.spring.exopoa.service;

import org.springframework.stereotype.Service;
import tibo.spring.exopoa.annotation.Logging;
import tibo.spring.exopoa.annotation.Performance;
import tibo.spring.exopoa.entity.Book;
import tibo.spring.exopoa.repository.BookRepository;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    @Logging
    @Performance
    public Iterable<Book> findAll() {
        return repository.findAll();
    }

    @Logging
    @Performance
    public Book findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Logging
    @Performance
    public Book save(Book book) {
        return repository.save(book);
    }

    @Logging
    @Performance
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
