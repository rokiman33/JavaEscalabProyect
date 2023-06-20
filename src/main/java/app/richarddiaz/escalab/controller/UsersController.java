package app.richarddiaz.escalab.controller;

import app.richarddiaz.escalab.model.dto.UsersDTO;
import app.richarddiaz.escalab.model.entity.ResponseModel;
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
    private final ResponseModel response = new ResponseModel();
    public UsersController(UsersServiceImpl usersService,
                           UsersRepository usersRepository) {
        this.usersService = usersService;
        this.usersRepository = usersRepository;
    }

    //GET ALL USERS
    @GetMapping("/")
    @Operation(summary = "Get all users")
    public ResponseModel getAllUsers() {
        if(usersRepository.count() == 0) {

            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.setMessage("No users found");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, response.getMessage().toString());
        }

        response.setStatus(HttpStatus.OK.value());
        response.setMessage(usersService.findAll());
        response.setRecordCount(usersService.findAll().size());

        return response;
    }


    //GET USER BY ID
    @GetMapping("/{id}")
    @Operation(summary = "Get user by id")
    public ResponseModel getUserById(@PathVariable("id") UUID id) {

        UsersDTO user = usersService.findById(id);

        if(user == null) {

            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.setMessage("User not found");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, response.getMessage().toString());
        }

        response.setStatus(HttpStatus.OK.value());
        response.setMessage(user);
        response.setRecordCount(1);

        return response;
    }

    //CREATE USER
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create user")
    public ResponseModel createUser(@RequestBody UsersDTO user) {

        UsersDTO newUser = usersService.save(user);

        if(newUser == null) {

            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage("User could not be created");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, response.getMessage().toString());
        }

        response.setStatus(HttpStatus.CREATED.value());
        response.setMessage(newUser);
        response.setRecordCount(1);

        return response;
    }

    //UPDATE USER
    @PutMapping("/")
    @Operation(summary = "Update user")
    public ResponseModel updateUser(@RequestBody UsersDTO user) {

        UsersDTO updatedUser = usersService.update(user);

        if(updatedUser == null) {

            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage("User could not be updated");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, response.getMessage().toString());
        }

        response.setStatus(HttpStatus.OK.value());
        response.setMessage(updatedUser);
        response.setRecordCount(1);
        return response;
    }

    //DELETE USER
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user")
    public ResponseModel deleteUser(@PathVariable("id") UUID id) {

        UsersDTO user = usersService.findById(id);

        if(user == null) {

            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.setMessage("User not Deleted");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, response.getMessage().toString());
        }

        usersService.delete(id);
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("User Deleted");
        response.setRecordCount(1);

        return response;
    }
    //LOGIN
    @PostMapping("/login")
    @Operation(summary = "Login")
    public ResponseModel login(@RequestBody Users user) {

        UUID loggedUser = usersService.login(user.getEmail(), user.getPassword());

        if(loggedUser == null) {

            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.setMessage("User not found");
            response.setRecordCount(0);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, response.getMessage().toString());
        }

        response.setStatus(HttpStatus.OK.value());
        response.setMessage(loggedUser.toString());
        response.setRecordCount(1);
        return response;
    }

}
