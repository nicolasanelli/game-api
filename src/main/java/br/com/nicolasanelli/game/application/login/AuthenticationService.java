package br.com.nicolasanelli.game.application.login;

import br.com.nicolasanelli.game.config.auth.ApplicationUser;
import br.com.nicolasanelli.game.domain.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {


    private static final Logger log = LoggerFactory.getLogger(AuthenticationService.class);
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    public AuthenticationService(AuthenticationManager authenticationManager, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    public ApplicationUser authenticate(LoginCommand input) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            input.email(),
                            input.password()
                    )
            );

            return userRepository.findByEmail(input.email())
                    .map(ApplicationUser::new)
                    .orElseThrow();
        } catch (BadCredentialsException e) {
            log.error(e.getMessage());
        }

        throw new BadCredentialsException("Bad credentials");
    }
}
