package com.distribuida.rest;

import com.distribuida.db.Book;
import com.distribuida.servicios.BookService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@ApplicationScoped
@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookRest {

    @Inject private BookService bookService;
    /**
     * Get          /books/{id}
     * GEt          /books
     * Post         /books
     * Put/patch    /books/{id}
     * Delete       /books/{id}
     */

    @GET
    @Path("/{id}")
    public Book findById(@PathParam("id") Integer id){

        return bookService.findById(id);
    }

    @GET
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @POST
    public void insert(Book book){

        bookService.insert(book);
    }

    @PUT
    @Path("/{id}")
    public void update(Book book, @PathParam("id") Integer id){
        book.setId(id);
        bookService.update(book);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id){

        bookService.delete(id);
    }
}
