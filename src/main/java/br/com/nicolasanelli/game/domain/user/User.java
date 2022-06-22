package br.com.nicolasanelli.game.domain.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter(AccessLevel.PRIVATE)
@Getter
public class User {

    private Integer id;
    private String username;
    private String email;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User(Integer id, String username, String email, String password) {
        this.setId(id);
        this.setUsername(username);
        this.setEmail(email);
        this.setPassword(password);
        this.setCreatedAt(LocalDateTime.now());
    }

    public void update(String username, String email) {
        this.setUsername(username);
        this.setEmail(email);
        this.setUpdatedAt(LocalDateTime.now());
    }
}
