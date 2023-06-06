package app.richarddiaz.escalab.service.impl;

import app.richarddiaz.escalab.model.dto.UsersDTO;
import app.richarddiaz.escalab.model.entity.Users;
import app.richarddiaz.escalab.model.repository.PhonesRepository;
import app.richarddiaz.escalab.model.repository.UsersRepository;
import app.richarddiaz.escalab.service.intf.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsersServiceImpl implements IUserService {
    UsersRepository usersRepository;
    PhonesRepository phonesRepository;
    public UsersServiceImpl(UsersRepository usersRepository, PhonesRepository phonesRepository) {
        this.usersRepository = usersRepository;
        this.phonesRepository = phonesRepository;
    }

    @Override
    public List<UsersDTO> findAll() {
        List<Users> users = usersRepository.findAll();
        List<UsersDTO> usersDTO = new ArrayList<>();

        for (Users user: users)
        {
            usersDTO.add(UsersDTO.fromEntity(user));
        }

        return usersDTO;
    }

    @Override
    public UsersDTO findById(UUID id) {
        Optional<Users> userop = usersRepository.findById(id);
        return userop.map(users -> new UsersDTO(users.getUsername(), users.getPassword(), users.getEmail(), users.getPhones())).orElse(null);
    }

    @Override
    public UsersDTO save(UsersDTO users) {
        //asignamos un UUDI al usuario
        UUID uuid = java.util.UUID.randomUUID();
        users.setId(uuid);
        users.setCreated(java.time.LocalDateTime.now());
        Users userEntity = UsersDTO.toEntity(users);
        usersRepository.save(userEntity);
        return UsersDTO.fromEntity(userEntity);
    }

    @Override
    public int update(Users users) {
        users.setModified(java.time.LocalDateTime.now());
        return usersRepository.updateIdByUsernameLike(users.getId(),users);
    }

    @Override
    public void delete(UUID id) {
        usersRepository.deleteById(id);
    }

    @Override
    public Users login(String username, String password) {
        return usersRepository.findByNombreUsuarioAndPassword(username, password);
    }


}
