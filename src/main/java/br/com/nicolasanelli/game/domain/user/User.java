package br.com.nicolasanelli.game.domain.user;

import java.time.LocalDateTime;

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

    private void setId(Integer id) {
        this.id = id;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    private void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
