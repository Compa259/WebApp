package masjav.nmd.spring.model.CustomerNotification;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "customer_notification")
@AssociationOverrides({
        @AssociationOverride(name = "customer", joinColumns = @JoinColumn(name = "customer_id")),
        @AssociationOverride(name = "notification", joinColumns = @JoinColumn(name = "notification_id"))
})
public class CustomerNotification {
    @EmbeddedId
    private CustomerNotificationId customerNotificationId;

    private Date created_at;
}
