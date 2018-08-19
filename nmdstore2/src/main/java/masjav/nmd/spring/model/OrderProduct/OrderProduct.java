package masjav.nmd.spring.model.OrderProduct;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "order_product")
@AssociationOverrides({
        @AssociationOverride(name = "order", joinColumns  = @JoinColumn(name = "order_id")),
        @AssociationOverride(name = "product", joinColumns  = @JoinColumn(name = "product_id"))
})
public class OrderProduct implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @EmbeddedId
    private OrderProductId orderProductId;

//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    @JsonBackReference
//    private Order order;
//
//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    @JsonBackReference
//    private Product product;

    private Integer quantity;

    private Long unitPrice;

    private Long discount;
}
