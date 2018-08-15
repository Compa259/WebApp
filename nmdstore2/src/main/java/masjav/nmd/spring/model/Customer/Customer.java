package masjav.nmd.spring.model.Customer;

import lombok.Data;
import masjav.nmd.spring.model.Notification.Notification;
import masjav.nmd.spring.model.Order.Order;
import masjav.nmd.spring.model.Role.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String name;

    @OneToMany(mappedBy = "customer")
    private Set<CustomerEAVVarchar> customerEAVVarchars;

    @OneToMany(mappedBy = "customer")
    private Set<CustomerEAVLong> customerEAVLongs;

    @OneToMany(mappedBy = "customer")
    private Set<CustomerEAVDateTime> customerEAVDateTimes;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;

    @ManyToMany
    @JoinTable(name = "customer_notification",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "notification_id"))
    private Set<Notification> notifications;

}
