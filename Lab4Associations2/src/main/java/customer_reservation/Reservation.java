package customer_reservation;

import book_publisher.Book;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    private Date date;




}
