package br.com.nicolasanelli.game.application.user;

import br.com.nicolasanelli.game.domain.user.User;
import br.com.nicolasanelli.game.domain.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceApplication {

    @Autowired
    private UserRepository repository;

    public void create(CreateUserCommand command) {
        User user = new User(
                repository.newId(),
                command.getUsername(),
                command.getEmail(),
                command.getPassword());

        repository.save(user);
    }

    public List<User> list() {
        return repository.list();
    }

    public User find(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void update(Integer id, UpdateUserCommand command) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.update(command.getUsername(), command.getEmail());

        repository.save(user);
    }

    public void remove(Integer id) {
        repository.removeById(id);
    }
}
