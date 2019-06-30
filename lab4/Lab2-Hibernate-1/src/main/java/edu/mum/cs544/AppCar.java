package edu.mum.cs544;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AppCar {

	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Owner owner1=new Owner();
        owner1.setName("Abeba");
        owner1.setAddress("1000 N 4th");

        Owner owner2=new Owner();
        owner2.setName("Ibrahim");
        owner2.setAddress("1000 N 4th");


        Car car1 = new Car("BMW", "SDA231", 30221.00, owner1);
        em.persist(car1);

        Car car2 = new Car("Mercedes", "HOO100", 4088.00,owner2);
        em.persist(car2);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();


        TypedQuery<Car> query = em.createQuery("from Car", Car.class);
        List<Car> carList = query.getResultList();
        for (Car car : carList) {
            System.out.println("brand= " + car.getBrand() + ", year= "
                    + car.getYear() + ", Owner= " + car.getOwner().getName());
        }
        em.getTransaction().commit();
        em.close();
    }
}

