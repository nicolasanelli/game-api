package br.com.nicolasanelli.game.domain.hero;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter(AccessLevel.PRIVATE)
@Getter
public class Hero {
    private Integer id;
    private Integer userId;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Hero(Integer id, Integer userId, String name) {
        this.setId(id);
        this.setUserId(userId);
        this.setName(name);
        this.setCreatedAt(LocalDateTime.now());
    }
}
