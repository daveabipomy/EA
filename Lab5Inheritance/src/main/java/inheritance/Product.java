package inheritance;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private String description;

    @OneToMany(mappedBy = "product",cascade = {CascadeType.PERSIST})
    private List<OrderLine> orderLineList=new ArrayList();

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
