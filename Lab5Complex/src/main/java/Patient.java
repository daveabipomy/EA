import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@SecondaryTable(name = "Address")
public class Patient {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    @Column(table = "Address")
    private String street;
    @Column(table = "Address")
    private String zip;
    @Column(table = "Address")
    private String city;

    public Patient() {
    }

    public Patient(String name, String street, String zip, String city) {
        this.name = name;
        this.street = street;
        this.zip = zip;
        this.city = city;
    }

}
