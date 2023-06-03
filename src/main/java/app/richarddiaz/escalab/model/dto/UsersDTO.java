package app.richarddiaz.escalab.model.dto;

import app.richarddiaz.escalab.model.entity.Phones;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsersDTO {

    private String id;

    @NotEmpty(message = "El nombre es obligatorio")
    private String NombreUsuario;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
            message = "La contraseña debe tener al menos 8 caracteres, incluyendo una letra minúscula, una letra mayúscula, un número y un caracter especial (@#$%^&+=).")
    private String password;

    private boolean Enabled;

    @Email(message = "Por favor, proporciona una dirección de correo electrónico válida.")
    @NotEmpty(message = "El correo electrónico es obligatorio.")
    private String email;

    private LocalDateTime Created;
    private  LocalDateTime Modified;

    @Valid
    private List<Phones> phones;



}
