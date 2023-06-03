package app.richarddiaz.escalab.model.repository;

import app.richarddiaz.escalab.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {
    Users findByNombreUsuario(String nombreUsuario);
    //login
    Users findByNombreUsuarioAndPassword(String nombreUsuario, String password);
}
