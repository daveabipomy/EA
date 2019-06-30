package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class App {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Students> query = em.createQuery("from edu.mum.cs544.Students", edu.mum.cs544.Students.class);
        List<Students> studentList = query.getResultList();
        for (Students student : studentList) {
            System.out.println("Student Name= " + student.getName());
        }
        em.getTransaction().commit();
        em.close();


        em = emf.createEntityManager();
        em.getTransaction().begin();
        Students student1 = new Students(987096,"Abeba","abeba.ibrahim@gmail.com","passw0rd");
        em.persist(student1);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Students> query1 = em.createQuery("from edu.mum.cs544.Students", edu.mum.cs544.Students.class);
        List<Students> studentList1 = query1.getResultList();
        for (Students student : studentList1) {
            System.out.println("Student Name= " + student.getName());
        }
        em.getTransaction().commit();
        em.close();


    }

    }
