package masjav.nmd.spring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@Entity
@Data
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long originalPrice;

    private Long salePrice;

    private Long totalNum;

    private Long remainingNum;

    private Long soldNum;

    private Date dateImported;

    private String status;

    @ManyToOne
    @JoinColumn(name = "item_category_id")
    @JsonManagedReference
    private ItemCategory itemCategory;

    @ManyToMany(mappedBy = "items")
    @JsonBackReference
    private Set<Invoice> invoices;
}
