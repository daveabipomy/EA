import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import model.Airline;
import model.Airplane;
import model.Airport;
import model.Flight;

import java.text.DateFormat;
import java.util.Locale;

import javax.persistence.*;

public class App {
    private final static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("lab6");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Airline airline1=new Airline();
        airline1.setName("American Airlines");

        Airplane airplane=new Airplane();
        airplane.setSerialnr("A123");
        airplane.setModel("A380");
        airplane.setCapacity(650);

        Airport airport=new Airport();
        airport.setName("Dallas");
        airport.setCity("Dallas");
        airport.setCountry("USA");
        airport.setAirportcode("D27");

        Airport airportd=new Airport();
        airportd.setName("dc");
        airportd.setCity("dc");
        airportd.setCountry("USA");
        airportd.setAirportcode("D27");
        Flight flight1=new Flight("D23",dateFormat.parse("01-01-2019"), LocalTime.now(),

                dateFormat.parse("01-01-2019"),LocalTime.now(),airline1,airportd,airport,airplane);
        em.persist(flight1);

        // a) TODO: Flights leaving USA capacity > 500
        System.out.println("Question A:");
        List<Flight> flights = em.createQuery("select f from Flight f join f.origin o join  f.airplane a where a.capacity>500 and o.country='USA' ", Flight.class).getResultList();
        System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:",
                "Arrives:");
        for (Flight flight : flights) {
            System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                    flight.getFlightnr(), flight.getOrigin().getCity(),
                    flight.getDepartureDate(), flight.getDepartureTime(),
                    flight.getDestination().getCity(),
                    flight.getArrivalDate(), flight.getArrivalTime());
        }
        System.out.println();

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // b) TODO: All airlines that use A380 airplanes
        System.out.println("Question B:");
        List<Airline> airlines = em.createQuery("select a from Airline a join a.flights f join f.airplane p where p.model='A380'", Airline.class).getResultList();
        System.out.println("Airlines that use A380s:");
        for (Airline airline : airlines) {
            System.out.println(airline.getName());
        }
        System.out.println();

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // c) TODO: Flights using 747 planes that don't belong to Star Alliance
        System.out.println("Question C:");
        flights = em.createQuery("select f from Flight f join f.airplane ap join f.airline ar where ap.model = '747' and ar.name <> 'Star Alliance' ", Flight.class).getResultList();
        System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:",
                "Arrives:");
        for (Flight flight : flights) {
            System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                    flight.getFlightnr(), flight.getOrigin().getCity(),
                    flight.getDepartureDate(), flight.getDepartureTime(),
                    flight.getDestination().getCity(),
                    flight.getArrivalDate(), flight.getArrivalTime());
        }
        System.out.println();

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
                Locale.US);
        DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT,
                Locale.US);

        // d) TODO: All flights leaving before 12pm on 08/07/2009
        System.out.println("Question D:");
        TypedQuery<Flight> query = em.createQuery("select f from Flight f where f.departureTime < :time and f.departureDate = :date ", Flight.class);
        query.setParameter("time", LocalTime.now());
        query.setParameter("date", df.parse("08/07/2009"), TemporalType.DATE);
        flights = query.getResultList();
        System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:",
                "Arrives:");
        for (Flight flight : flights) {
            System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                    flight.getFlightnr(), flight.getOrigin().getCity(),
                    flight.getDepartureDate(), flight.getDepartureTime(),
                    flight.getDestination().getCity(),
                    flight.getArrivalDate(), flight.getArrivalTime());
        }
        System.out.println();
        em.getTransaction().commit();
        em.close();
    }
}
