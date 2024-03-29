package app.richarddiaz.escalab.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

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

    @Column(name = "number", nullable = false, unique = false)
    private String Number;

    @Column(name = "citycode", nullable = false)
    private String CityCode;

    @Column(name = "countrycode", nullable = false)
    private String CountryCode;

}
