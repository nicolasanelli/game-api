package br.com.nicolasanelli.game.web;

import br.com.nicolasanelli.game.application.user.CreateUserCommand;
import br.com.nicolasanelli.game.application.user.UpdateUserCommand;
import br.com.nicolasanelli.game.application.user.UserServiceApplication;
import br.com.nicolasanelli.game.domain.user.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserServiceApplication service;

    public UserController(UserServiceApplication service) {
        this.service = service;
    }

    @GetMapping
    public List<User> list() {
        return service.list();
    }

    @GetMapping("{id}")
    public User find(@PathVariable Integer id) {
        return service.find(id);
    }

    @PostMapping
    public void create(@RequestBody CreateUserCommand command) {
        service.create(command);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Integer id, @RequestBody UpdateUserCommand command) {
        service.update(id, command);
    }

    @DeleteMapping("{id}")
    public void remove(@PathVariable Integer id) {
        service.remove(id);
    }
}
