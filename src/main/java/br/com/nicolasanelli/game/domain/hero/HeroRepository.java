package br.com.nicolasanelli.game.domain.hero;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class HeroRepository {
    private Integer nextId = 1;
    private List<Hero> heroes = new ArrayList<>();

    public HeroRepository() {
        heroes.add(new Hero(newId(), 1, "Kat Loyalar"));
        heroes.add(new Hero(newId(), 1, "Brad Loyalar"));
        heroes.add(new Hero(newId(), 2, "Jin"));
        heroes.add(new Hero(newId(), 2, "Groonch"));
    }

    public Integer newId() {
        return this.nextId++;
    }


    public void save(Hero hero){
        if (existsWithId(hero.getId())) {
            update(hero);
        } else {
            insert(hero);
        }
    }

    public Optional<Hero> findById(Integer id) {
        return heroes.stream().filter(c -> id.equals(c.getId())).findFirst();
    }

    public List<Hero> list() {
        return heroes;
    }

    public void removeById(Integer id) {
        Hero oldHero = heroes.stream()
                .filter(c -> id.equals(c.getId()))
                .findFirst().orElse(null);
        heroes.remove(oldHero);
    }

    private boolean existsWithId(Integer id) {
        return heroes.stream().anyMatch(c -> id.equals(c.getId()));
    }

    private void insert(Hero hero) {
        heroes.add(hero);
    }

    private void update(Hero hero) {
        removeById(hero.getId());
        heroes.add(hero);
        heroes = heroes.stream()
                .sorted(Comparator.comparing(Hero::getId))
                .collect(Collectors.toList());
    }

    public List<Hero> listByUserId(Integer userId) {
        return heroes.stream()
                .filter(hero -> hero.getUserId().equals(userId))
                .collect(Collectors.toList());
    }
}
