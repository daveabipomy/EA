package employee_laptop;

import employee_laptop.Employee;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Laptop {
    @Id
    @GeneratedValue
    private Long Id;

    private String name;

    private String spec;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Employee employee;
}
