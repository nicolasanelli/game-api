package br.com.nicolasanelli.game.web;

import br.com.nicolasanelli.game.application.login.LoginCommand;
import br.com.nicolasanelli.game.application.login.AuthenticationService;
import br.com.nicolasanelli.game.application.login.LoginData;
import br.com.nicolasanelli.game.config.auth.ApplicationUser;
import br.com.nicolasanelli.game.config.jwt.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final JwtService jwtService;

    public AuthenticationController(final AuthenticationService authenticationService, JwtService jwtService) {
        this.authenticationService = authenticationService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginData> authenticate(@RequestBody LoginCommand command) {
        ApplicationUser authenticatedUser = authenticationService.authenticate(command);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginData loginResponse = new LoginData(jwtToken, jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
