package masjav.nmd.spring.model.Order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import masjav.nmd.spring.model.Customer.Customer;
import masjav.nmd.spring.model.Product.Product;

import javax.persistence.*;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(name = "order_product",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName="id")
    )
    private Set<Product> products;
}
