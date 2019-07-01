package inheritance;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class OrderLine {
    @Id
    @GeneratedValue
    private Long id;
    private int quantity;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Order order;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Product product;

    public OrderLine(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }
}
