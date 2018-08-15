package masjav.nmd.spring.model.Role;

import lombok.Data;
import masjav.nmd.spring.model.Customer.Customer;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne(mappedBy = "user")
    private Customer customer;
}
