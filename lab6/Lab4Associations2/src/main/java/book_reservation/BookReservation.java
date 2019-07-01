package book_reservation;

import book_publisher.Book;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name="book_reservation")
public class BookReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    private Date date;

    @ManyToOne
    private Book book;


}
