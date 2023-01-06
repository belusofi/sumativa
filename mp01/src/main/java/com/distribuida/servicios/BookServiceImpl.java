package com.distribuida.servicios;
import com.distribuida.configuracion.ConfiguracionDB;
import com.distribuida.db.Book;
import jakarta.enterprise.context.ApplicationScoped;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookServiceImpl implements BookService {
// public Book findById(Integer id){
    public Book findById(Integer id){
        //Book ret = new Book();
        //ret.setId(id);
        //ret.setIsbn("isbn" + id);
        //ret.setTitle("title" + id);
        //ret.setAuthor("author" + id);
        //ret.setPrice( id * 30.24 );
        Jdbi jdbi= ConfiguracionDB.init();
        Handle handle= jdbi.open();
        Book book=new Book();
        book=handle.createQuery("SELECT * FROM \"books\" where id= :id")
                .bind("id",id)
                .mapToBean(Book.class)
                .first();
    return book;
    }
    private List<Book> books= new ArrayList<>();
    {
        Book lib1 = new Book();
        lib1.setId(1);
        lib1.setIsbn("Pruebas");
        lib1.setTitle("Pruebas");
        lib1.setAuthor("Jairo");
        lib1.setPrice( 56.24 );
        books.add(lib1);
        Book lib2 = new Book();
        lib2.setId(2);
        lib2.setIsbn("Pruebas2");
        lib2.setTitle("Pruebas2");
        lib2.setAuthor("Israel");
        lib2.setPrice( 70.24 );
        books.add(lib2);
        Book lib3 = new Book();
        lib3.setId(3);
        lib3.setIsbn("Pruebas3");
        lib3.setTitle("Pruebas3");
        lib3.setAuthor("Oscar");
        lib3.setPrice( 70.24 );
        books.add(lib3);
    }
    @Override
    public List<Book> findAll(){
        Jdbi jdbi= ConfiguracionDB.init();
        Handle handle= jdbi.open();
        return handle.createQuery("SELECT * FROM \"books\" ")
                .mapToBean(Book.class)
                .list();

    }

    @Override
    public boolean delete(Integer id) {

        Jdbi jdbi= ConfiguracionDB.init();
        Handle handle= jdbi.open();

        Boolean borrar=false;
        if (borrar == false){
            //handle.createQuery("DELETE FROM \"books\" where id= :id")
            handle.createUpdate("delete from \"books\" where id = :id ")
                    .bind("id", id)
                    .execute();
            borrar=true;
        }else {
            borrar=false;
        }
        return borrar;
    }


    public Book update(Book book,Integer id) {
        Jdbi jdbi= ConfiguracionDB.init();
        Handle handle= jdbi.open();
        //UPDATE nombre_tabla SET columna1 = 'nuevo_valor' WHERE columna1 = 'valor1'
              //book1=handle.createQuery("UPDATE \"books\" set \"isbn\"=:isbn,\"title\"=:title,\"author\"=:author,\"price\":price where id=:id")
          handle.createUpdate("UPDATE \"books\" set isbn=:isbn,title=:title,author=:author,price=:price where id= :id")
                .bind("id",id)
                .bind("isbn",book.getIsbn())
                .bind("title",book.getTitle())
                .bind("author",book.getAuthor())
                .bind("price",book.getPrice())
                .execute();
        //books.set(id, book);
        return book;
    }


    public List<Book> insert(Book book) {
        Jdbi jdbi= ConfiguracionDB.init();
        Handle handle= jdbi.open();
        handle.createUpdate("insert into books (id, \"isbn\",\"title\",\"author\",\"price\") values (:id, :isbn,:title,:author,:price)")
                .bind("id",book.getId())
                .bind("isbn",book.getIsbn())
                .bind("title",book.getTitle())
                .bind("author",book.getAuthor())
                .bind("price",book.getPrice())
                .execute();
            //.isOne();
        return handle.createQuery("SELECT * FROM \"books\" ")
                .mapToBean(Book.class)
                .list();
     //   books.add(book);
       // return book;
    }

}
