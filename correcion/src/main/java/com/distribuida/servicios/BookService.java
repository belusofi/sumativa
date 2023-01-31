package com.distribuida.servicios;

import com.distribuida.db.Book;

import java.util.List;

public interface BookService {
    public Book findById(Integer id);
    public List<Book> findAll();
   void insert(Book book);
    void update(Book book);
    void delete(Integer id);

}
