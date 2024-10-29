package br.com.nicolasanelli.game.application.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateUserCommandTest {
    @Test
    void test_create() {
        UpdateUserCommand command = new UpdateUserCommand(
                "username", "email"
        );

        assertEquals("username", command.username());
        assertEquals("email", command.email());
    }
}
