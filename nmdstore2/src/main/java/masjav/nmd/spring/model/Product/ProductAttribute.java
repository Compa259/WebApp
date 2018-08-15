package masjav.nmd.spring.model.Product;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table (name = "product_attribute")
public class ProductAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;

    private String type;

    private Boolean is_required;

    private Boolean is_unique;

    private String note;

    @OneToMany(mappedBy = "productAttribute")
    private Set<ProductEAVVarchar> productEAVVarchars;

    @OneToMany(mappedBy = "productAttribute")
    private Set<ProductEAVLong> productEAVLongs;

    @OneToMany(mappedBy = "productAttribute")
    private Set<ProductEAVDateTime> productEAVDateTimes;
}
