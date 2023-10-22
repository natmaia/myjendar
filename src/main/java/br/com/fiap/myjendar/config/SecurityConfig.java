package br.com.fiap.myjendar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
        .oauth2Login(Customizer.withDefaults())
        .build();
    }
    
}


// Para incluir login com senha (incluida do application)
// .formLogin(Customizer.withDefaults())
