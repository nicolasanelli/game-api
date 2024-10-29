package br.com.nicolasanelli.game.config.auth;

import br.com.nicolasanelli.game.domain.user.UserRepository;
import br.com.nicolasanelli.game.exceptions.ApiError;
import br.com.nicolasanelli.game.exceptions.AuthorizationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ApplicationUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public ApplicationUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .map(ApplicationUser::new)
                .orElseThrow(() -> new AuthorizationException(new ApiError("401.001", String.format("Username %s not found", username))));
    }
}
