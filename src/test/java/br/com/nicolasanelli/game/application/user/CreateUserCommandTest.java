package br.com.nicolasanelli.game.application.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateUserCommandTest {
    @Test
    void test_create() {
        CreateUserCommand command = new CreateUserCommand(
                "username", "email", "password"
        );

        assertEquals("username", command.getUsername());
        assertEquals("email", command.getEmail());
        assertEquals("password", command.getPassword());
    }
}
