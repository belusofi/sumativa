package com.distribuida.servicios;

import com.distribuida.db.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Book findById(Integer id);
    List<Book>findAll();
    boolean delete(Integer id);
    Book update(Book book, Integer id);
    List<Book> insert(Book book);


}
