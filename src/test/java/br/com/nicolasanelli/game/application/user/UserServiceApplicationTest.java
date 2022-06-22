package br.com.nicolasanelli.game.application.user;

import br.com.nicolasanelli.game.domain.user.User;
import br.com.nicolasanelli.game.domain.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceApplicationTest {

    @Mock
    User user;
    @Mock
    private UserRepository repository;
    private UserServiceApplication service;

    @BeforeEach
    void setup() {
        service = new UserServiceApplication(repository);
    }

    @Test
    void test_create() {
        CreateUserCommand command = new CreateUserCommand(
                "username", "email", "password"
        );
        when(repository.newId()).thenReturn(1);

        service.create(command);

        verify(repository).newId();
        verify(repository).save(any());
    }

    @Test
    void test_list() {
        when(repository.list()).thenReturn(List.of(user));
        List<User> users = service.list();

        assertEquals(user, users.get(0));
        verify(repository).list();
    }

    @Test
    void test_findById() {
        when(repository.findById(1)).thenReturn(Optional.of(user));
        User userFound = service.find(1);

        assertEquals(user, userFound);
    }

    @Test
    void test_findByIdWhenEmptyShouldThrowException() {
        when(repository.findById(1)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> service.find(1))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("User not found");
    }

    @Test
    void test_update() {
        UpdateUserCommand command = new UpdateUserCommand(
                "username", "email"
        );

        when(repository.findById(1)).thenReturn(Optional.of(user));
        service.update(1, command);

        verify(user).update(eq("username"), eq("email"));
        verify(repository).save(user);
    }

    @Test
    void test_updateWhenEmptyShouldThrowException() {
        when(repository.findById(1)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> service.find(1))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("User not found");
    }

    @Test
    void test_remove() {
        service.remove(1);

        verify(repository).removeById(eq(1));
    }
}
