package br.com.nicolasanelli.game.domain.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class HeroTest {

    private Hero hero;
    @BeforeEach
    void setup() {
        hero = new Hero(1, 2, "Some Name");
    }

    @Test
    void test_create() {
        assertEquals(1, hero.getId());
        assertEquals(2, hero.getUserId());
        assertEquals("Some Name", hero.getName());
        assertNotNull(hero.getCreatedAt());
        assertNull(hero.getUpdatedAt());
    }
}
