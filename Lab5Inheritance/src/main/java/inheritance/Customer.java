package notInheritance;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    private String firstname;
    private String lastname;

//    @OneToMany(mappedBy = "customer",cascade = {CascadeType.PERSIST})

    @OneToMany
            (
                    mappedBy = "customer",
                    cascade = CascadeType.PERSIST,
                    orphanRemoval = true
            )

    private List<Order> orderList=new ArrayList();

    public Customer(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;

    }

    public void addOrder(Order order)
    {
        order.setCustomer(this);
        orderList.add(order);
    }
}
