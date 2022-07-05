package br.com.nicolasanelli.game.application.user;

import br.com.nicolasanelli.game.domain.user.User;
import br.com.nicolasanelli.game.domain.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceApplication {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceApplication(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public void create(CreateUserCommand command) {
        User user = new User(
                repository.newId(),
                command.getUsername(),
                command.getEmail(),
                passwordEncoder.encode(command.getPassword()));

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
