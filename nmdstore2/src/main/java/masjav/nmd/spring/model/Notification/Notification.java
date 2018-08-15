package masjav.nmd.spring.model.Notification;

import lombok.Data;
import masjav.nmd.spring.model.Customer.Customer;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToMany(mappedBy = "notifications")
    private Set<Customer> customers;
}
