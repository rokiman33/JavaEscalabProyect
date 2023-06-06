package app.richarddiaz.escalab.model.dto;

import app.richarddiaz.escalab.model.entity.Phones;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PhonesDTO {

    private Long phone_id;
    @NotEmpty(message = "El Numero es obligatorio")
    private String Number;
    @NotEmpty(message = "La Ciudad es obligatoria")
    private String CityCode;
    @NotEmpty(message = "el Codigo de Pais es obligatorio")
    private String CountryCode;

    public static PhonesDTO fromEntity(Phones phones){
        PhonesDTO phonesDTO = new PhonesDTO();
        phonesDTO.setPhone_id(phones.getPhone_id());
        phonesDTO.setNumber(phones.getNumber());
        phonesDTO.setCityCode(phones.getCityCode());
        phonesDTO.setCountryCode(phones.getCountryCode());
        return phonesDTO;
    }

    public static Phones toEntity(PhonesDTO phonesDTO){
        Phones phones = new Phones();
        phones.setPhone_id(phonesDTO.getPhone_id());
        phones.setNumber(phonesDTO.getNumber());
        phones.setCityCode(phonesDTO.getCityCode());
        phones.setCountryCode(phonesDTO.getCountryCode());
        return phones;
    }


}
