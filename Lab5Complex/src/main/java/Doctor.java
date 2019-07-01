import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Data
@Entity
public class Doctor {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "type")
    private String doctorType;
    private String firstName;
    private String lastName;

    public Doctor() {
    }

    public Doctor(String doctorType, String firstName, String lastName) {
        this.doctorType = doctorType;
        this.firstName = firstName;
        this.lastName = lastName;
    }


}
