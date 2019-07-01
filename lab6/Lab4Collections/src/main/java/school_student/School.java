package school_student;

import lombok.Data;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Entity
public class School {
    @javax.persistence.Id
    @GeneratedValue
    private Long Id;
    private String school_name;

    @OneToMany( cascade = CascadeType.PERSIST,orphanRemoval = true)
    @JoinColumn(name="schoolId")
    @MapKeyColumn(name="studentId")
    private Map<Integer, Student> students= new HashMap();

}
