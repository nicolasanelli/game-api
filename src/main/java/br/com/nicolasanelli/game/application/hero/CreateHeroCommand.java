package br.com.nicolasanelli.game.application.hero;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateHeroCommand {
    private Integer userId;
    private String name;
}
