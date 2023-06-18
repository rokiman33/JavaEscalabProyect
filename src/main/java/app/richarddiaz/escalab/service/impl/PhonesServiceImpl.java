package app.richarddiaz.escalab.service.impl;

import app.richarddiaz.escalab.model.dto.PhonesDTO;
import app.richarddiaz.escalab.model.entity.Phones;
import app.richarddiaz.escalab.model.repository.PhonesRepository;
import app.richarddiaz.escalab.service.intf.IPhonesService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PhonesServiceImpl implements IPhonesService {

    PhonesRepository phonesRepository;

    public PhonesServiceImpl(PhonesRepository phonesRepository) {
        this.phonesRepository = phonesRepository;
    }


    @Override
    public List<PhonesDTO> findbyUserId(UUID id) {
        List<Phones> phonesList = phonesRepository.findByUserId(id);
        List<PhonesDTO> phonesDTOList = new  ArrayList<>();

        for (Phones phone: phonesList)
        {
            phonesDTOList.add(PhonesDTO.fromEntity(phone));
        }

        return phonesDTOList;
    }

    @Override
    public PhonesDTO save(PhonesDTO phones, UUID id) {
        //asignamos un UUDI al usuario

        Phones entity = PhonesDTO.toEntity(phones);
        //entity.getUsers().setId(id);
        phonesRepository.save(entity);

        return PhonesDTO.fromEntity(entity);
    }

    @Override
    public int update(PhonesDTO phones) {
        Phones entity = PhonesDTO.toEntity(phones);
        return phonesRepository.updateIdByPhone(phones.getPhone_id(), entity);
    }

    @Override
    public void delete(Long id) {
        phonesRepository.deleteById(id);

    }
}
