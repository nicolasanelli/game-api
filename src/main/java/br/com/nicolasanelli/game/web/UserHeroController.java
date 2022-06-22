package br.com.nicolasanelli.game.web;

import br.com.nicolasanelli.game.application.hero.HeroServiceApplication;
import br.com.nicolasanelli.game.domain.hero.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/{id}/heroes")
public class UserHeroController {

    @Autowired
    private HeroServiceApplication service;

    @GetMapping
    public List<Hero> list(@PathVariable Integer id) {
        return service.listByUserId(id);
    }
}
