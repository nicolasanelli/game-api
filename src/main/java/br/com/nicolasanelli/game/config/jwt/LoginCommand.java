package br.com.nicolasanelli.game.config.jwt;

public class LoginCommand {
    private String username;
    private String password;

    public LoginCommand() {}
    public LoginCommand(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
