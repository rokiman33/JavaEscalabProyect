package app.richarddiaz.escalab.model.dto;

import app.richarddiaz.escalab.model.entity.Phones;
import app.richarddiaz.escalab.model.entity.Users;
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
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsersDTO {

    private UUID id;

    @NotEmpty(message = "El nombre es obligatorio")
    private String UserName;

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

    public UsersDTO(UUID id,String username, String password, String email,boolean enabled,LocalDateTime created,LocalDateTime modified, List<Phones> phones) {
        this.id = id;
        this.UserName = username;
        this.password = password;
        this.email = email;
        this.phones = phones;
        this.Enabled = enabled;
        this.Created = created;
        this.Modified = modified;

    }

    //Conecto el DTO con la entidad
    public static  UsersDTO fromEntity(Users users){
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setId(users.getId());
        usersDTO.setUserName(users.getUsername());
        usersDTO.setPassword(users.getPassword());
        usersDTO.setEnabled(users.isEnabled());
        usersDTO.setEmail(users.getEmail());
        usersDTO.setCreated(users.getCreated());
        usersDTO.setModified(users.getModified());
        usersDTO.setPhones(users.getPhones());
        return usersDTO;
    }

    //Conecto la entidad con el DTO
    public static Users toEntity(UsersDTO usersDTO){
        Users users = new Users();
        users.setId(usersDTO.getId());
        users.setUsername(usersDTO.getUserName());
        users.setPassword(usersDTO.getPassword());
        users.setEnabled(usersDTO.isEnabled());
        users.setEmail(usersDTO.getEmail());
        users.setCreated(usersDTO.getCreated());
        users.setModified(usersDTO.getModified());
        users.setPhones(usersDTO.getPhones());
        return users;
    }

}
