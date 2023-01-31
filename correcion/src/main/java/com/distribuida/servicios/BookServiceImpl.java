package com.distribuida.servicios;

import com.distribuida.db.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jdbi.v3.core.Jdbi;

import java.util.List;

@ApplicationScoped
public class BookServiceImpl implements BookService {
  // Forma1 DataSource?
  // @Inject private DataSource dataSource;
  @Inject private Jdbi jdbi;
    @Override
    public Book findById(Integer id){
      /*Forma 1
       Connection con=dataSource.getConnection();
        PreparedStatement pstnt=con.prepareStatement("select * from books where id=?");
        ResultSet rs=pstnt.executeQuery();

        while(rs.next()){
            rs.getInt(1,)
        }*/

        return null;
    }
    @Override
    public List<Book> findAll(){
     List<Book> ret=  jdbi.withHandle(handle->{
        return handle.createQuery("SELECT * from books order by id asc")
                 .mapToBean(Book.class)
                 .list();
       } );
        return ret;
    }

    @Override
    public void insert(Book book){

    }
    @Override
    public void update(Book book){

    }

    @Override
    public void delete(Integer id){

    }
}
