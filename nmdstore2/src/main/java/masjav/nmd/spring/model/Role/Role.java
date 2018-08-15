package masjav.nmd.spring.model.Role;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String rolename;

    @OneToMany(mappedBy = "role")
    private Set<User> users;
}
