package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AppBook {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2010");
        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse("3/12/2000");
        Date date3=new SimpleDateFormat("dd/MM/yyyy").parse("1/2/2005");

        Book book1 = new Book("Enterprise Architecture","EA-544","Tina",100.00,date1);
        em.persist(book1);

        Book book2 = new Book("Software Engineering","SE-415","David",100.00,date2);
        em.persist(book2);

        Book book3 = new Book("Database","DB-8415","William",100.00,date3);
        em.persist(book3);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Book> query = em.createQuery("from Book", Book.class);
        List<Book> bookList = query.getResultList();
        for (Book book : bookList) {
            System.out.println("Book title= " + book.getTitle() + ", ISBN= "
                    + book.getISBN() + ", Author= " + book.getAuthor());
        }
        em.getTransaction().commit();
        em.close();


        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Book> query1 = em.createQuery("from Book", Book.class);
        List<Book> bookList1 = query1.getResultList();

        Book b1=bookList1.get(0);
        b1.setTitle("Software testing");
        em.merge(b1);

        Book b2= em.getReference(Book.class,2);
        em.remove(b2);
        em.getTransaction().commit();
        em.close();


        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Book> query2 = em.createQuery("from Book", Book.class);
        List<Book> bookList2 = query2.getResultList();
        for (Book book : bookList2) {
            System.out.println("Book title= " + book.getTitle() + ", ISBN= "
                    + book.getISBN() + ", Author= " + book.getAuthor());
        }
        em.getTransaction().commit();
        em.close();
    }
}
