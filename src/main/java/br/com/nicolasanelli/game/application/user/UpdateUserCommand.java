package br.com.nicolasanelli.game.application.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateUserCommand {
    private String username;
    private String email;
}
