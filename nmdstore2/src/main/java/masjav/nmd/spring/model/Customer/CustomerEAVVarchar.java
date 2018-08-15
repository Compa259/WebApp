package masjav.nmd.spring.model.Customer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customer_eav_varchar")
public class CustomerEAVVarchar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;

    private Integer store_id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "customer_attribute_id")
    @JsonBackReference
    private CustomerAttribute customerAttribute;
}
