package br.com.nicolasanelli.game.config.admin;

import br.com.nicolasanelli.game.application.user.CreateUserCommand;
import br.com.nicolasanelli.game.application.user.UserServiceApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminConfig {

    private final UserServiceApplication service;

    @Value("${application.admin.enabled}")
    private Boolean enabled;
    @Value("${application.admin.username}")
    private String username;
    @Value("${application.admin.email}")
    private String email;
    @Value("${application.admin.password}")
    private String password;

    public AdminConfig(UserServiceApplication service) {
        this.service = service;
    }

    @Bean
    public void setup() {
        if (enabled) {
            service.create(new CreateUserCommand(username, email, password));
        }
    }
}
