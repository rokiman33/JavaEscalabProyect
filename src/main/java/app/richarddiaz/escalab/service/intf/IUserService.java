package app.richarddiaz.escalab.service.intf;

import app.richarddiaz.escalab.model.entity.Users;

import java.util.List;
import java.util.UUID;

public interface IUserService {

    //obtener todos los usuarios
    List<Users> findAll();

    //obtener un usuario por id
    Users findById(UUID id);

    //grabar un usuario
    Users save(Users users);

    //actualizar un usuario
    Users update(Users users);

    //eliminar un usuario
    void delete(UUID id);

    //login
    Users login(String username, String password);



}
