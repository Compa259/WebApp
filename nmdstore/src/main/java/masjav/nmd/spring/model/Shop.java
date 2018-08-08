package masjav.nmd.spring.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "Shop")
public class Shop {
    @Id
    private Long id;

    private String name;

    private Integer phone;

    private String email;
}
