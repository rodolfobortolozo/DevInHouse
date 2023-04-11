package tech.devinhouse.locadora.core.Security;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

  private final JWTFilter jwtFilter;

  public SpringSecurityConfig(JWTFilter jwtFilter) {
    this.jwtFilter = jwtFilter;
  }

  @Bean
  public SecurityFilterChain filterChain (HttpSecurity http) throws Exception
  { http
          .csrf().disable()
          .addFilterBefore(this.jwtFilter, UsernamePasswordAuthenticationFilter.class)
          .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
          .and()
          .authorizeHttpRequests()
          .requestMatchers("/api/auth/register").permitAll()
          .requestMatchers("/api/auth/login").permitAll()
          .requestMatchers("/tabprecos/*").permitAll()
          .requestMatchers("/tabprecos").authenticated()
          //.requestMatchers("/admin/**").hasAuthority("ADMIN")
          .and()
          .exceptionHandling()
          .authenticationEntryPoint(
                  (request, response, authException) ->
                          response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized")
          );


    return  http.build();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception
  { return authenticationConfiguration.getAuthenticationManager();}

  @Bean
  public PasswordEncoder passwordEncoder()
  { return new BCryptPasswordEncoder(); }
}
