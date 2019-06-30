import employee_laptop.Employee;
import employee_laptop.Laptop;
import passenger_flight.Flight;
import passenger_flight.Passenger;
import school_student.School;
import school_student.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {

        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Employee emp=new Employee();
        emp.setFirst_name("Abeba");
        emp.setLast_name("Yimer");

        Laptop laptop=new Laptop();
        laptop.setName("HP");
        laptop.setSpec("new");
        laptop.setEmployee(emp);

        Laptop laptop1=new Laptop();
        laptop1.setName("TOSHIBA");
        laptop1.setSpec("new");
        laptop1.setEmployee(emp);

        em.persist(laptop);
        em.persist(laptop1);
        em.getTransaction().commit();


        em.getTransaction().begin();
        Passenger passenger=new Passenger();
        passenger.setFirst_name("Abeba");
        passenger.setLast_name("yimer");

        Passenger passenger1=new Passenger();
        passenger1.setFirst_name("David");
        passenger1.setLast_name("William");

        List<Passenger> passengerList=new ArrayList();
        passengerList.add(passenger);
        passengerList.add(passenger1);

        Flight flight=new Flight();
        flight.setFlight_number("A1234");
        flight.setFrom("fairfield");
        flight.setTo("Dc");
        flight.setPassengerList(passengerList);
        em.persist(flight);
        em.getTransaction().commit();


        em.getTransaction().begin();
        Student student=new Student();
        student.setStudentId(1);
        student.setFirst_name("Abeba");
        student.setLast_name("Yimer");

        Student student1=new Student();
        student1.setStudentId(2);
        student1.setFirst_name("David");
        student1.setLast_name("William");
        Map<Integer,Student> studentList=new HashMap();
        studentList.put(student.getStudentId(),student);
        studentList.put(student1.getStudentId(),student1);

        School school=new School();
        school.setSchool_name("MUM");
        school.setStudents(studentList);
        em.persist(school);
        em.getTransaction().commit();




        em.close();


    }
}
