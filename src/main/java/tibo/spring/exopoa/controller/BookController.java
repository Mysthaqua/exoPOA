package tibo.spring.exopoa.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tibo.spring.exopoa.entity.Book;
import tibo.spring.exopoa.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Book> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Book create(@Validated @RequestBody Book book) {
        return service.save(book);
    }

    @PutMapping
    public Book update(@Validated @RequestBody Book book) {
        return service.save(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
}
