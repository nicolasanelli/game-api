package br.com.nicolasanelli.game.config.auth;

import br.com.nicolasanelli.game.config.auth.ApplicationUserDetailsService;
import br.com.nicolasanelli.game.config.jwt.JwtAuthenticationFilter;
import br.com.nicolasanelli.game.config.jwt.JwtConfig;
import br.com.nicolasanelli.game.config.jwt.JwtVerifierFilter;
import br.com.nicolasanelli.game.domain.user.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig {

    private final AuthenticationConfiguration authenticationConfiguration;
    private final JwtConfig jwtConfig;
    private final UserRepository userRepository;

    public ApplicationSecurityConfig(AuthenticationConfiguration authenticationConfiguration,
                                     JwtConfig jwtConfig,
                                     UserRepository userRepository) {
        this.authenticationConfiguration = authenticationConfiguration;
        this.jwtConfig = jwtConfig;
        this.userRepository = userRepository;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        AuthenticationManager authenticationManager = authenticationConfiguration.getAuthenticationManager();

        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager, jwtConfig))
                .addFilterAfter(new JwtVerifierFilter(jwtConfig), JwtAuthenticationFilter.class)
                .authorizeRequests()
                .anyRequest()
                .authenticated()
        ;

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new ApplicationUserDetailsService(userRepository);
    }
}
