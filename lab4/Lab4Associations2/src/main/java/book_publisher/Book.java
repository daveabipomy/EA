package book_publisher;

import lombok.Data;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    private String ISBN;

    private String title;

    private String author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name="book_publisher",joinColumns = { @JoinColumn(name = "book_id") },inverseJoinColumns = { @JoinColumn(name = "publisher_id")})
    private Publisher publisher;





}
