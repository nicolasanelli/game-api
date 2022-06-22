package br.com.nicolasanelli.game.domain.hero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class HeroRepositoryTest {

    private HeroRepository repository;
    private Hero hero;

    @BeforeEach
    void setup() {
        repository = new HeroRepository();
        hero = new Hero(repository.newId(), 3, "Some Guy");
    }

    @Test
    void test_newId() {
        assertEquals(6, repository.newId());
        assertEquals(7, repository.newId());
        assertEquals(8, repository.newId());
    }

    @Test
    void test_list() {
        assertEquals(4, repository.list().size());
    }

    @Test
    void test_saveShouldInsert() {
        assertEquals(4, repository.list().size());
        repository.save(hero);
        assertEquals(5, repository.list().size());
    }

    @Test
    void test_saveShouldUpdate() {
        Hero hero = new Hero(1, 1, "Some Guy");

        assertEquals(4, repository.list().size());
        repository.save(hero);
        assertEquals(4, repository.list().size());
    }

    @Test
    void test_findById() {
        Hero hero = repository.findById(1).get();
        assertEquals(1, hero.getId());
    }

    @Test
    void test_removeById() {
        repository.removeById(1);
        assertEquals(3, repository.list().size());
    }

    @Test
    void test_listByUserId() {
        List<Hero> heroes = repository.listByUserId(1);
        assertEquals(2, heroes.size());
    }
}
