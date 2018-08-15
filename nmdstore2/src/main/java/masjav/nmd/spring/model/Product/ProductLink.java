package masjav.nmd.spring.model.Product;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_link")
public class ProductLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "linked_product_id")
    private Product productLinked;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
