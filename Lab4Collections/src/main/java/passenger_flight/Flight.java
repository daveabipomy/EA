package passenger_flight;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Flight {
    @Id
    @GeneratedValue
    private Long id;
    private String flight_number;
    @Column(name="flightfrom")
    private String from;
    @Column(name="flightto")
    private String to;
    @OneToMany
            (
            cascade = CascadeType.PERSIST,
            orphanRemoval = true
    )
    @JoinColumn(name = "flight_id",referencedColumnName = "id")
    @OrderColumn(name="flight_order")
    private List<Passenger> passengerList=new ArrayList();


}
