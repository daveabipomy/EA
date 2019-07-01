package passenger_flight;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Passenger {

    @Id @GeneratedValue
    private Long id;
    private String first_name;
    private String last_name;

}
