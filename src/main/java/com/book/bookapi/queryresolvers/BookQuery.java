package com.book.bookapi.queryresolvers;

import com.book.bookapi.model.Author;
import com.book.bookapi.model.Book;
import com.book.bookapi.repository.AuthorRepository;
import com.book.bookapi.repository.BookRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BookQuery implements GraphQLQueryResolver{

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;

    public Iterable<Book> allBook(){
        return bookRepository.findAll();
    }

    public Book getBookByName(String name){
        return bookRepository.findBookByName(name);
    }

    public Iterable<Author> allAuthor(){
        return authorRepository.findAll();
    }

}
