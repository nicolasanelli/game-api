package br.com.nicolasanelli.game.application.user;

public class UpdateUserCommand {
    private final String username;
    private final String email;

    public UpdateUserCommand(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
