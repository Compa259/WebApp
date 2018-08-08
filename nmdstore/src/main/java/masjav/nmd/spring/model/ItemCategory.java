package masjav.nmd.spring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@Entity
@Data
@Table(name = "item_category")
public class ItemCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "itemCategory", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Item> items;
}
