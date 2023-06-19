package app.richarddiaz.escalab.controller;

import app.richarddiaz.escalab.model.dto.UsersDTO;
import app.richarddiaz.escalab.model.repository.UsersRepository;
import app.richarddiaz.escalab.service.impl.UsersServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

import app.richarddiaz.escalab.model.entity.Users;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/users")
public class UsersController {

    UsersServiceImpl usersService;
    private final UsersRepository usersRepository;

    public UsersController(UsersServiceImpl usersService,
                           UsersRepository usersRepository) {
        this.usersService = usersService;
        this.usersRepository = usersRepository;
    }

    //GET ALL USERS
    @GetMapping("/")
    @Operation(summary = "Get all users")
    public List<UsersDTO> getAllUsers() {
        if(usersRepository.count() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No users found");
        }
        return usersService.findAll();
    }


    //GET USER BY ID
    @GetMapping("/{id}")
    @Operation(summary = "Get user by id")
    public UsersDTO getUserById(@PathVariable("id") UUID id) {

        UsersDTO user = usersService.findById(id);

        if(user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        return user;
    }

    //CREATE USER
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create user")
    public UsersDTO createUser(@RequestBody UsersDTO user) {

        UsersDTO newUser = usersService.save(user);

        if(newUser == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User could not be created");
        }

        return newUser;
    }

    //UPDATE USER
    @PutMapping("/")
    @Operation(summary = "Update user")
    public UsersDTO updateUser(@RequestBody UsersDTO user) {

        UsersDTO updatedUser = usersService.update(user);

        if(updatedUser == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User could not be updated");
        }

        return updatedUser;
    }

    //DELETE USER
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete user")
    public void deleteUser(@PathVariable("id") UUID id) {

        UsersDTO user = usersService.findById(id);

        if(user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        usersService.delete(id);

    }
    //LOGIN
    @PostMapping("/login")
    @Operation(summary = "Login")
    public Users login(@RequestBody Users user) {

        Users loggedUser = usersService.login(user.getUsername(), user.getPassword());

        if(loggedUser == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        return loggedUser;
    }

}
