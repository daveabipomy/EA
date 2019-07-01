package student_course;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue
    private Long course_id;
    private String course_name;

    @ManyToMany(mappedBy = "courseList",cascade = CascadeType.ALL)
    private List<Student> studentList=new ArrayList();
}
