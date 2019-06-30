package employee_laptop;

import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
public class Employee {
    @javax.persistence.Id
    @GeneratedValue
    private Long Id;

    private String first_name;

    private String last_name;

    @OneToMany(mappedBy = "employee")
    private Set<Laptop> laptopList=new HashSet<>();

}
