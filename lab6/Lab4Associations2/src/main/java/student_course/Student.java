package student_course;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long student_id;

    private String first_name;
    private String last_name;

    @ManyToMany(cascade = CascadeType.ALL)

    @JoinTable(name = "Student_Course",
            joinColumns = { @JoinColumn(name = "Student_id") },
            inverseJoinColumns = { @JoinColumn(name = "Course_id") })
    private List<Course> courseList=new ArrayList();
}
