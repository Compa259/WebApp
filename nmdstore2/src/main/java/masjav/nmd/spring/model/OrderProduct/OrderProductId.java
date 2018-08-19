package masjav.nmd.spring.model.OrderProduct;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import masjav.nmd.spring.model.Order.Order;
import masjav.nmd.spring.model.Product.Product;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
public class OrderProductId implements Serializable {
    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;
}
