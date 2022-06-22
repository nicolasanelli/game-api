package br.com.nicolasanelli.game.application.hero;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateHeroCommandTest {

    @Test
    void test_create() {
        CreateHeroCommand command = new CreateHeroCommand(12, "Some Hero");

        assertEquals(12, command.getUserId());
        assertEquals("Some Hero", command.getName());
    }
}
