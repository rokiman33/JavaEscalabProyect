package app.richarddiaz.escalab.model.repository;

import app.richarddiaz.escalab.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {
    @Transactional
    @Modifying
    @Query("update Users u set u.Modified = local_datetime, u.Email = ?1, u.Username = ?2, u.Password = ?3, u.Enabled= ?4 where u.id = ?5")
    int updateIdByUsernameLike(@NonNull UUID id, Users users);

    //login
    @Query("select u.id from Users u where u.Email = :email and u.Password = :password")
    UUID findIdByEmailAndPassword(@Param("email") String email,@Param("password") String password);
}
