package com.example.emtlab1.dataholder;

import com.example.emtlab1.model.Country;
import com.example.emtlab1.model.Author;
import com.example.emtlab1.model.Book;
import com.example.emtlab1.model.Category;
import com.example.emtlab1.model.Country;
import com.example.emtlab1.repository.AuthorRepository;
import com.example.emtlab1.repository.BookRepository;
import com.example.emtlab1.repository.CountryRepository;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {

    public static List<Country> countries = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();
    public static List<Book> books = new ArrayList<>();

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CountryRepository countryRepository;

    public DataHolder(AuthorRepository authorRepository, BookRepository bookRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.countryRepository = countryRepository;
    }


    @PostConstruct
    public void init(){
        Country mkd = new Country("NorthMacedonia", "Europe");
        Country srb = new Country("Serbia", "Europe");
        Country usa = new Country("United States of America", "North America");
        Country bos = new Country("Bosnia", "Europe");


        this.countryRepository.save(mkd);
        this.countryRepository.save(srb);
        this.countryRepository.save(usa);
        this.countryRepository.save(bos);


        Author dostoevski = new Author("Fyodor", "Dostoyevsky", mkd);
        Author andric = new Author("Ivo", "Andric", srb);
        Author will = new Author("William", "Shakespeare", usa);
        Author har = new Author("Harold", "Robbins", bos);


        this.authorRepository.save(dostoevski);
        this.authorRepository.save(andric);
        this.authorRepository.save(will);
        this.authorRepository.save(har);


        Book book1 = new Book("In Search of Lost Time", Category.CLASSICS, dostoevski, 10);
        Book book2 = new Book("Ulysses", Category.DRAMA, andric, 5);
        Book book3 = new Book("Don Quixote", Category.FANTASY, har, 3);
        Book book4 = new Book("One Hundred Years of Solitude", Category.THRILLER, will, 1);
        Book book5 = new Book("The Great Gatsby", Category.BIOGRAPHY, will, 20);
        Book book6 = new Book("Moby Dick", Category.CLASSICS, dostoevski, 6);
        Book book7 = new Book("War and Peace", Category.FANTASY, har, 30);
        Book book8 = new Book("Hamlet", Category.NOVEL, will, 2);


        this.bookRepository.save(book1);
        this.bookRepository.save(book2);
        this.bookRepository.save(book3);
        this.bookRepository.save(book4);
        this.bookRepository.save(book5);
        this.bookRepository.save(book6);
        this.bookRepository.save(book7);
        this.bookRepository.save(book8);
    }


}
