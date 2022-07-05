package br.com.nicolasanelli.game.domain.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserRepository {
    private Integer nextId = 1;
    private List<User> users = new ArrayList<>();

    public Integer newId() {
        return this.nextId++;
    }

    public void save(User user){
        if (existsWithId(user.getId())) {
            update(user);
        } else {
            insert(user);
        }
    }

    public Optional<User> findById(Integer id) {
        return users.stream().filter(u -> id.equals(u.getId())).findFirst();
    }

    public List<User> list() {
        return users;
    }

    public void removeById(Integer id) {
        User oldUser = users.stream()
                .filter(u -> id.equals(u.getId()))
                .findFirst().orElse(null);
        users.remove(oldUser);
    }

    private boolean existsWithId(Integer id) {
        return users.stream().anyMatch(u -> id.equals(u.getId()));
    }

    private void insert(User user) {
        users.add(user);
    }

    private void update(User user) {
        removeById(user.getId());
        users.add(user);
        users = users.stream()
                .sorted(Comparator.comparing(User::getId))
                .collect(Collectors.toList());
    }

    public Optional<User> findByName(String username) {
        return users.stream().filter(u -> username.equals(u.getUsername())).findFirst();
    }
}
