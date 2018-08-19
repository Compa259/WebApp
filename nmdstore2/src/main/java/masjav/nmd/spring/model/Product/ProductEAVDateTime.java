package masjav.nmd.spring.model.Product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "product_eav_datetime")
public class ProductEAVDateTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date value;

    private Integer store_id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference(value = "product")
//    @JsonIgnore
    private Product product;

    @ManyToOne
    @JoinColumn(name = "product_attribute_id")
    @JsonBackReference
    //@JsonIgnore
    private ProductAttribute productAttribute;
}
