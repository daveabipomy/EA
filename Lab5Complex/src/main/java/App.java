
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class App {
    private final static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("lab5");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Doctor doctor1 = new Doctor("Internist", "Dawit", "Getahun");
        Doctor doctor2 = new Doctor("Dentist", "Abeba", "Yimer");

        Payment payment1 = new Payment("1-1-2019", 150);
        Payment payment2 = new Payment("2-2-2019", 300);

        Patient patient1 = new Patient("Benjamin", "4th ST","52557", "Fairfield");
        Patient patient2 = new Patient("David", "4th ST","52556", "Fairfield");

        Appointment appointment1 = new Appointment("21-05-2019", patient1,payment1, doctor1);
        Appointment appointment2 = new Appointment("12-06-2019", patient2,payment2, doctor2);

        em.persist(appointment1);
        em.persist(appointment2);

        em.getTransaction().commit();
        em.close();
    }
}
