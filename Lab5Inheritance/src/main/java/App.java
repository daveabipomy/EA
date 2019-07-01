import inheritance.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class App {
    private static EntityManagerFactory emf;
    private final static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static void main(String[] args) throws Exception {

        emf = Persistence.createEntityManagerFactory("lab5");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Product product1 = new Product("Laptop", "New");
        Product product2 = new Product("TV", "Used");
        em.persist(product1);
        em.persist(product2);

        Order order1 = new Order(dateFormat.parse("6-30-2019"));
        Order order2 = new Order(dateFormat.parse("5-10-2019"));



        CD cd = new CD("Movie","New","The Vow");
        DVD dvd = new DVD("Type","New","Romantic");
        Book book = new Book("Book","New","The Secrete");

        OrderLine orderLine1 = new OrderLine(50,book);
        OrderLine orderLine2 = new OrderLine(33,cd);
        OrderLine orderLine3 = new OrderLine(12,dvd);


        order1.addOrderLine(orderLine1);
        order1.addOrderLine(orderLine2);
        order1.addOrderLine(orderLine3);

        Customer customer1 = new Customer("Abeba", "Yimer");
        customer1.addOrder(order1);

        em.persist(customer1);
        em.getTransaction().commit();
        em.close();
    }
}
