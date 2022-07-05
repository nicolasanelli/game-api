package br.com.nicolasanelli.game.domain.hero;

import java.time.LocalDateTime;

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

    private void setId(Integer id) {
        this.id = id;
    }

    private void setUserId(Integer userId) {
        this.userId = userId;
    }

    private void setName(String name) {
        this.name = name;
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

    public Integer getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
