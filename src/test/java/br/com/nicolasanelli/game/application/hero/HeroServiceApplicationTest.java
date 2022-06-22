package br.com.nicolasanelli.game.application.hero;

import br.com.nicolasanelli.game.domain.hero.Hero;
import br.com.nicolasanelli.game.domain.hero.HeroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HeroServiceApplicationTest {

    @Mock
    private Hero hero;
    @Mock
    private HeroRepository repository;
    private HeroServiceApplication service;

    @BeforeEach
    void setup() {
        service = new HeroServiceApplication(repository);
    }

    @Test
    void test_create() {
        CreateHeroCommand command = new CreateHeroCommand(1, "New Hero");

        when(repository.newId()).thenReturn(5);

        service.create(command);

        verify(repository).newId();
        verify(repository).save(any());
    }

    @Test
    void test_remove() {
        service.remove(1);

        verify(repository).removeById(eq(1));
    }

    @Test
    void test_listByUserId() {
        when(repository.listByUserId(eq(1)))
                .thenReturn(List.of(hero));

        List<Hero> heroes = service.listByUserId(1);

        assertEquals(hero, heroes.get(0));
    }
}
