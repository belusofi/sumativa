package com.distribuida.rest;

import com.distribuida.configuracion.ConfiguracionDB;
import com.distribuida.db.Book;
import com.distribuida.servicios.BookService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;

@Path("/books")
public class BookRest {
    @Inject private BookService bookService;
    @Inject private ConfiguracionDB dbConfig;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book findById(@PathParam("id") Integer id){
        return bookService.findById(id);
    }


   /* @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book findById(@PathParam("id") Integer id){
        return bookService.findById(id);
    }*/

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> findAll(){
        return bookService.findAll();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Book> insert(Book book){
        return bookService.insert(book);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Book update(Book book,@PathParam("id") Integer id){
        return bookService.update(book, id);
    }
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean delete(@PathParam("id") Integer id) {
        return bookService.delete(id);
    }


}
