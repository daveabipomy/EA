package inheritance;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
public class CD extends Product{
    private String artist;

    public CD(String artist) {
        this.artist = artist;
    }

    public CD(String name, String description, String artist) {
        super(name, description);
        this.artist = artist;
    }
}
