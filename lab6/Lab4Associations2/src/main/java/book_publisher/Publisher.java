package book_publisher;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Publisher {
    @Id
    @GeneratedValue
    private Long id;

    private String publisher_name;
}
