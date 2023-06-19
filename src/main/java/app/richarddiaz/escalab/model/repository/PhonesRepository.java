package app.richarddiaz.escalab.model.repository;

import app.richarddiaz.escalab.model.dto.PhonesDTO;
import app.richarddiaz.escalab.model.entity.Phones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PhonesRepository extends JpaRepository<Phones, Long> {

    @Transactional
    @Modifying
    @Query("update Phones p set p.Number = ?1, p.CityCode = ?2, p.CountryCode = ?3 where p.phone_id = ?4")
    int updateIdByPhone(@NonNull Long id, Phones phones);

    @Query("select p.Number, p.CityCode, p.CountryCode from Phones p where p.phone_id = ?1")
    List<Phones> findByUserId(UUID id);

    @Query("select p.Number, p.CityCode, p.CountryCode from Phones p where p.Number = ?1")
    Optional<Phones> findByNumber(String number);


}
