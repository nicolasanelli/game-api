package br.com.nicolasanelli.game.web;

import br.com.nicolasanelli.game.application.hero.CreateHeroCommand;
import br.com.nicolasanelli.game.application.hero.HeroServiceApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/heroes")
public class HeroController {

    private final HeroServiceApplication service;

    public HeroController(HeroServiceApplication service) {
        this.service = service;
    }

    @PostMapping
    public void create(@RequestBody CreateHeroCommand command) {
        service.create(command);
    }

    @DeleteMapping("{id}")
    public void remove(@PathVariable Integer id) {
        service.remove(id);
    }
}
