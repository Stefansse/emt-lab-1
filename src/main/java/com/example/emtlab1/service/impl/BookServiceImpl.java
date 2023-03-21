package com.example.emtlab1.service.impl;

import com.example.emtlab1.model.Author;
import com.example.emtlab1.model.Book;
import com.example.emtlab1.model.Category;
import com.example.emtlab1.model.dto.BookDto;
import com.example.emtlab1.model.exceptions.BookNoMoreCopiesException;
import com.example.emtlab1.model.exceptions.BookNotFoundExceptionByAuthorId;
import com.example.emtlab1.model.exceptions.BookNotFoundExceptionByBookId;
import com.example.emtlab1.repository.AuthorRepository;
import com.example.emtlab1.repository.BookRepository;
import com.example.emtlab1.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {

    private  final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }




    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> addBook(String name, Category category, Author author, Integer availableCopies) {
        return Optional.of(this.bookRepository.save(new Book(name, category, author, availableCopies)));
    }


    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new BookNotFoundExceptionByAuthorId(bookDto.getAuthor()));

        return Optional.of(this.bookRepository.save(new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies())));
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
       Book book = this.bookRepository.findById(id).orElseThrow( () -> new BookNotFoundExceptionByAuthorId(bookDto.getAuthor()));
       book.setAvailableCopies(bookDto.getAvailableCopies());
       Author author = this.authorRepository.findById(bookDto.getAuthor()).orElseThrow(() -> new BookNotFoundExceptionByAuthorId(bookDto.getAuthor()));
       book.setAuthor(author);
       Category category = Category.valueOf(bookDto.getCategory().toString());
       book.setCategory(category);
       book.setName(bookDto.getName());
       return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> markAsTaken(Long id) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundExceptionByBookId(id));
        Integer availableCopies = book.getAvailableCopies();
        if(availableCopies == 0){
            throw new BookNoMoreCopiesException("Book has no more copies");
        }
        availableCopies -= 1;

        book.setAvailableCopies(availableCopies);
        return Optional.of(this.bookRepository.save(book));

    }

    @Override
    public Optional<Book> leastUsed(Long id) {
        return Optional.empty();
    }
}
