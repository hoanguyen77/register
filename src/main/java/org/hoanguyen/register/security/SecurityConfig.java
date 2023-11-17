package org.hoanguyen.register.security;

import org.hoanguyen.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserService userService;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
http.authorizeHttpRequests(
        auth -> auth.requestMatchers("/",
                "/css/*","/js/*","/img/*",
                "/member-sign-up", "/process-user","/confirmation",
                "/list-of-members","/find-member-by-email",
                "/find-member-by-email/{email}",
                "/login").permitAll()
                .requestMatchers("/account")
                .hasAnyRole("MEMBER","SENIOR")
                .anyRequest().authenticated())
        .formLogin(form -> form.loginPage("/login")
                .loginProcessingUrl("/login")
                .successForwardUrl("/home")
                .failureForwardUrl("/")
                .permitAll())
                .logout(logout -> logout
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .permitAll());





        return http.build();
    }

}