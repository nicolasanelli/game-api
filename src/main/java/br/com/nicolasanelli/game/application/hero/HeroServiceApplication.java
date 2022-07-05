package br.com.nicolasanelli.game.application.hero;

import br.com.nicolasanelli.game.domain.hero.Hero;
import br.com.nicolasanelli.game.domain.hero.HeroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HeroServiceApplication {

    private final HeroRepository repository;

    public void create(CreateHeroCommand command) {
        Hero hero = new Hero(
                repository.newId(),
                command.getUserId(),
                command.getName()
        );
        repository.save(hero);
    }

    public void remove(Integer id) {
        repository.removeById(id);
    }

    public List<Hero> listByUserId(Integer userId) {
        return repository.listByUserId(userId);
    }
}
