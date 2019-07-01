package inheritance;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Data
@Entity
@NoArgsConstructor
public class Book extends Product{
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public Book(String name, String description, String title) {
        super(name, description);
        this.title = title;
    }
}
