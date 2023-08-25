package com.bushub.core.config.security;

import com.bushub.core.config.security.jwt.BushubJwtAuthConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
@RequiredArgsConstructor
public class ResourceServerSecurityConfig {

  private final BushubJwtAuthConverter jwtAuthConverter;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
      .authorizeHttpRequests(customizer -> customizer.anyRequest().authenticated())
      .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwtConfigurer ->
          jwtConfigurer.jwtAuthenticationConverter(jwtAuthConverter)
        )
      );

    return httpSecurity.build();
  }
}
