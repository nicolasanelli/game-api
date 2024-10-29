package br.com.nicolasanelli.game.application.user;

public record CreateUserCommand(String username, String email, String password) {
}
