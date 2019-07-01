package inheritance;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
public class DVD extends Product{
    private String genre;

    public DVD(String genre) {
        this.genre = genre;
    }

    public DVD(String name, String description, String genre) {
        super(name, description);
        this.genre = genre;
    }
}
