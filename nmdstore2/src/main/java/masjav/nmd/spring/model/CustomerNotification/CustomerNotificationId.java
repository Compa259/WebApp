package masjav.nmd.spring.model.CustomerNotification;


import lombok.Data;
import masjav.nmd.spring.model.Customer.Customer;
import masjav.nmd.spring.model.Notification.Notification;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
public class CustomerNotificationId implements Serializable {
    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Notification notification;
}
