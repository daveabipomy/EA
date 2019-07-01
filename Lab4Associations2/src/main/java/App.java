import book_publisher.Book;
import book_publisher.Publisher;
import book_reservation.BookReservation;
import customer_reservation.Customer;
import customer_reservation.Reservation;
import employee_department.Department;
import employee_department.Employee;
import student_course.Course;
import student_course.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class App {
    private static EntityManagerFactory emf;
    private final static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static void main(String[] args) throws Exception {

        emf = Persistence.createEntityManagerFactory("lab4");

        EntityManager em = emf.createEntityManager();

        //EMPLOYEE-DEPARTMENT
        em.getTransaction().begin();
        Employee employee1 = new Employee();
        employee1.setFirst_name("Abeba");
        employee1.setLast_name("Yimer");
        employee1.setSalary(5000);

        Employee employee2 = new Employee();
        employee2.setFirst_name("David");
        employee2.setLast_name("William");
        employee2.setSalary(5000);

        List<Employee> employeeList=new ArrayList();
        employeeList.add(employee1);
        employeeList.add(employee2);

        Department department = new Department();
        department.setDepartment_name("Compro");
        department.setEmployeeList(employeeList);
        department.setLocation("fairfield");
        em.persist(department);
        em.getTransaction().commit();

        // BOOK_PUBLISHER
        em.getTransaction().begin();
        Publisher publisher=new Publisher();
        publisher.setPublisher_name("Mega");

        Book book1=new Book();
        book1.setISBN("A675");
        book1.setAuthor("Benjamin");
        book1.setTitle("Enterprise Architecture");
        book1.setPublisher(publisher);

        Book book2=new Book();
        book2.setISBN("A234");
        book2.setAuthor("Nael");
        book2.setTitle("SQL server Database");
        book2.setPublisher(publisher);
        em.persist(book1);
        em.persist(book2);
        em.getTransaction().commit();


        //STUDENT_COURSE
        em.getTransaction().begin();
        List<Student> studentList=new ArrayList();
        List<Student> studentList1=new ArrayList();
        List<Course> courseList=new ArrayList();

        Student student1=new Student();
        student1.setFirst_name("Abeba");
        student1.setLast_name("Yimer");


        Student student2=new Student();
        student2.setFirst_name("David");
        student2.setLast_name("William");

        Student student3=new Student();
        student3.setFirst_name("Benjamin");
        student3.setLast_name("Nael");

        studentList.add(student1);
        studentList.add(student2);

        studentList1.add(student1);
        studentList1.add(student3);

        Course course1=new Course();
        course1.setCourse_name("EA");
        course1.setStudentList(studentList);

        Course course2=new Course();
        course2.setCourse_name("WAA");
        course2.setStudentList(studentList1);

        courseList.add(course1);
        courseList.add(course2);
        student1.setCourseList(courseList);
        student2.setCourseList(Arrays.asList(course1));
        student3.setCourseList(Arrays.asList(course2));

        em.persist(course1);
        em.persist(course2);
        em.getTransaction().commit();

        //CUSTOMER_RESERVATION
        em.getTransaction().begin();
        Customer customer=new Customer();

        Reservation reservation1=new Reservation();
        Date date = dateFormat.parse("2018-09-09");
        reservation1.setDate(date);

        Reservation reservation2=new Reservation();
        Date date1 = dateFormat.parse("2019-01-01");
        reservation2.setDate(date1);

        List<Reservation> reservationList=new ArrayList();
        reservationList.add(reservation1);
        reservationList.add(reservation2);

        customer.setName("Abeba");
        customer.setReservationList(reservationList);
        em.persist(customer);


        BookReservation reservationBook1=new BookReservation();
        reservationBook1.setDate(date1);
        reservationBook1.setBook(book1);

        BookReservation reservationBook2=new BookReservation();
        reservationBook2.setDate(date1);
        reservationBook2.setBook(book2);

        em.persist(reservationBook1);
        em.persist(reservationBook2);
        em.getTransaction().commit();

        em.close();


    }
}
