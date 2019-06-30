package notInheritance;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity(name="Order_table")
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    private Date date;

    @ManyToOne(cascade = { CascadeType.PERSIST })
//    @JoinColumn(referencedColumnName = "id")
    private Customer customer;

    @OneToMany(mappedBy = "order",cascade = {CascadeType.PERSIST})
    private List<OrderLine> orderLineList=new ArrayList();


    public Order(Date date) {
        this.date = date;
    }
}
