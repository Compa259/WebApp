package masjav.nmd.spring.model.Order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import masjav.nmd.spring.model.Customer.Customer;

import javax.persistence.*;

@Data
@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;

//    @OneToMany(mappedBy = "order")
//    private Set<OrderProduct> orderProducts;

//    @ManyToMany
//    @JoinTable(name = "order_product",
//            joinColumns = @JoinColumn(name = "order_id", referencedColumnName="id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName="id")
//    )
//    private Set<Product> products;
}
