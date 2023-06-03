package app.richarddiaz.escalab.service.impl;

import app.richarddiaz.escalab.model.entity.Users;
import app.richarddiaz.escalab.model.repository.UsersRepository;
import app.richarddiaz.escalab.service.intf.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsersServiceImpl implements IUserService {

    UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Users findById(UUID id) {
        return usersRepository.findById(id).orElse(null);
    }

    @Override
    public Users save(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public Users update(Users users) {
        return usersRepository.save(users);
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
