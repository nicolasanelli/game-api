package br.com.nicolasanelli.game.domain.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

    private UserRepository repository;
    User user;

    @BeforeEach
    void setup() {
        repository = new UserRepository();
        user = new User(repository.newId(), "username", "email", "password");
    }

    @Test
    void test_newId() {
        assertEquals(2, repository.newId());
    }

    @Test
    void test_list() {
        assertEquals(0, repository.list().size());
    }

    @Test
    void test_saveShouldInsert() {
        assertEquals(0, repository.list().size());
        repository.save(user);
        assertEquals(1, repository.list().size());
    }

    @Test
    void test_saveShouldUpdate() {
        assertEquals(0, repository.list().size());
        repository.save(user);
        assertEquals(1, repository.list().size());
        repository.save(user);
        assertEquals(1, repository.list().size());
    }

    @Test
    void test_findById() {
        repository.save(user);

        User user = repository.findById(1).get();
        assertEquals(1, user.getId());
    }

    @Test
    void test_removeById() {
        repository.removeById(1);
        assertEquals(0, repository.list().size());
    }
}
