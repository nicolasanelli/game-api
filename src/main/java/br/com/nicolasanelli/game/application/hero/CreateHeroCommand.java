package br.com.nicolasanelli.game.application.hero;

public class CreateHeroCommand {
    private final Integer userId;
    private final String name;


    public CreateHeroCommand(Integer userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}
