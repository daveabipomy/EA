package employee_department;

import lombok.Data;

import javax.persistence.*;

@Data

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String first_name;
    private String last_name;
    private double salary;
    @ManyToOne
    private Department department;
}
