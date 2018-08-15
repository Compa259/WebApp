package masjav.nmd.spring.model.Customer;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "customer_attribute")
public class CustomerAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;

    private String type;

    private Boolean is_required;

    private Boolean is_unique;

    private String note;

    @OneToMany(mappedBy = "customerAttribute")
    private Set<CustomerEAVVarchar> customerEAVVarchars;

    @OneToMany(mappedBy = "customerAttribute")
    private Set<CustomerEAVLong> customerEAVLongs;

    @OneToMany(mappedBy = "customerAttribute")
    private Set<CustomerEAVDateTime> customerEAVDateTimes;
}
