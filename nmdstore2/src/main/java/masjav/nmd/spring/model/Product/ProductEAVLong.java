package masjav.nmd.spring.model.Product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_eav_long")
public class ProductEAVLong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long value;

    private Integer store_id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference(value = "product")
//    @JsonIgnore
    private Product product;

    @ManyToOne
    @JoinColumn(name = "product_attribute_id")
    @JsonBackReference
//    @JsonIgnore
    private ProductAttribute productAttribute;

    public String toString(){
        return "nmdstore2";
    }
}
