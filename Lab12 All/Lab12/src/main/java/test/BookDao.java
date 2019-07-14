package test;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public class BookDao {
//    @PersistenceContext
//    private EntityManager em;
//
//
//    public BookDao() {
////		 add(new Car("Volvo", "S80", 1999, "Silver"));
////		 add(new Car("Honda", "Accord", 1997, "Red"));
//    }
//
//    public List<Book> getAll() {
//        return em.createQuery("from Book", Book.class).getResultList();
//    }
//
//    public void add(Book book) {
//
//        System.out.println("Dao"+ book.getISBN()+" :"+book.getPublisher());
//        em.persist(book);
//        System.out.println("Dao1"+ book.getISBN()+" :"+book.getPublisher());
//    }
//
//
//    public Book get(int id) {
//        return em.find(Book.class, id);
//    }
//
//
//    public void update(Book book) {
//        em.merge(book);
//    }
//
//
//    public void delete(int bookId) {
//        Book c = em.getReference(Book.class, bookId);
//        em.remove(c);
//    }
}
