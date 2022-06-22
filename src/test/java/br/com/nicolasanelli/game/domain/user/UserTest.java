package br.com.nicolasanelli.game.domain.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserTest {

    private User user;
    @BeforeEach
    public void setup() {
        user = new User(1, "username", "email", "password");
    }
    @Test
    void test_create() {
        assertEquals(1, user.getId());
        assertEquals("username", user.getUsername());
        assertEquals("email", user.getEmail());
        assertEquals("password", user.getPassword());
        assertNotNull( user.getCreatedAt());
        assertNull(user.getUpdatedAt());
    }

    @Test
    void test_update() {
        user.update("new-username", "new-email");

        assertEquals(1, user.getId());
        assertEquals("new-username", user.getUsername());
        assertEquals("new-email", user.getEmail());
        assertEquals("password", user.getPassword());
        assertNotNull(user.getCreatedAt());
        assertNotNull(user.getUpdatedAt());
    }
}
