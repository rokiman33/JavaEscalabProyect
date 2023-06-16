package app.richarddiaz.escalab.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "phones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Phones extends RepresentationModel<Phones>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long phone_id;

    @Column(name = "number", nullable = false, unique = true)
    private String Number;

    @Column(name = "citycode", nullable = false)
    private String CityCode;

    @Column(name = "countrycode", nullable = false)
    private String CountryCode;

    @Column(name = "user_id", insertable = false, updatable = false)
    private UUID userId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id")
    private Users users;

}
