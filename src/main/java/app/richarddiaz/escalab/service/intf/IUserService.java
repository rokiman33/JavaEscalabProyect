package app.richarddiaz.escalab.service.intf;

import app.richarddiaz.escalab.model.dto.UsersDTO;
import app.richarddiaz.escalab.model.entity.Phones;
import app.richarddiaz.escalab.model.entity.Users;
import org.apache.catalina.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {

    //obtener todos los usuarios
    List<UsersDTO> findAll();

    //obtener un usuario por id
    UsersDTO findById(UUID id);

    //grabar un usuario
    UsersDTO save(UsersDTO users);

    //actualizar un usuario
    UsersDTO update(UsersDTO users);

    //eliminar un usuario
    void delete(UUID id);

    //login
    UUID login(String email, String password);





}
