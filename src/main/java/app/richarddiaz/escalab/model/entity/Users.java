package app.richarddiaz.escalab.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.dialect.function.TruncFunction;
import org.springframework.hateoas.RepresentationModel;

import javax.print.attribute.standard.DateTimeAtCreation;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users extends RepresentationModel<Users>  {

    @Id
    private UUID id;

    @Column(name = "username", nullable = false, unique = true, length = 20)
    private String NombreUsuario;

    @Column(name = "password", nullable = false, length = 60)
    private String Password;

    @Column(name = "enabled", nullable = false)
    private boolean Enabled;

    @Column(name = "email", nullable = false, unique = true)
    private String Email;

    @Column(name = "created", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime Created;

    @Column(name = "modified", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime Modified;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phones> phones;


}
