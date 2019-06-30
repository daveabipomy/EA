package notInheritance;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OrderLine {
    @Id
    @GeneratedValue
    private Long id;
    private int quantity;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Order order;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Product product;
}
