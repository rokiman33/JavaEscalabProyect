package app.richarddiaz.escalab.service.intf;

import app.richarddiaz.escalab.model.dto.PhonesDTO;
import java.util.List;
import java.util.UUID;

public interface IPhonesService {

    //listamos todos los telefonos asignados a un usuario
    List<PhonesDTO> findbyUserId(UUID id);

    //grabar un telefono
    PhonesDTO save(PhonesDTO phones, UUID id);

    //actualizar un telefono
    int update(PhonesDTO phones);

    //eliminar un telefono
    void delete(Long id);


}
