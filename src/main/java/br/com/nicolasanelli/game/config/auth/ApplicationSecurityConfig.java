package br.com.nicolasanelli.game.config.auth;

import br.com.nicolasanelli.game.config.jwt.JwtAuthenticationFilter;
import br.com.nicolasanelli.game.domain.user.UserRepository;
import br.com.nicolasanelli.game.exceptions.FilterChainExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig {

    private final FilterChainExceptionHandler filterChainExceptionHandler;

    public ApplicationSecurityConfig(FilterChainExceptionHandler filterChainExceptionHandler) {
        this.filterChainExceptionHandler = filterChainExceptionHandler;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity,
                                           JwtAuthenticationFilter jwtAuthenticationFilter) throws Exception {


        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(http -> http
                        .requestMatchers("/actuator/**").permitAll()
                        .requestMatchers("api/v1/auth/login").permitAll()
                        .anyRequest().authenticated()
                )
                // https://docs.spring.io/spring-security/reference/servlet/configuration/xml-namespace.html#ns-custom-filters
                .addFilterBefore(filterChainExceptionHandler, LogoutFilter.class)
                .addFilterAfter(jwtAuthenticationFilter, LogoutFilter.class)
                .httpBasic(Customizer.withDefaults())
        ;

        return httpSecurity.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new ApplicationUserDetailsService(userRepository);
    }
}
