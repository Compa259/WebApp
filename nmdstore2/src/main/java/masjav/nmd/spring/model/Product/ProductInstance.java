package masjav.nmd.spring.model.Product;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_instance")
public class ProductInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    private Integer restNum;

    private Long price;

    private Long sale_price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
