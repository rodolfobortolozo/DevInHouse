package com.example.securityjwt.config;

import com.example.securityjwt.repository.UsuarioRepository;
import com.example.securityjwt.service.AutenticacaoService;
import com.example.securityjwt.service.TokenService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final TokenService tokenService;
    private final UsuarioRepository repository;
    private final AutenticacaoService autenticacaoService;
    private final DataSource dataSource;

    public WebSecurityConfig(UsuarioRepository repository, TokenService tokenService, AutenticacaoService autenticacaoService, DataSource dataSource){
        this.repository = repository;
        this.tokenService = tokenService;
        this.autenticacaoService = autenticacaoService;
        this.dataSource = dataSource;
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder encoder() { return new BCryptPasswordEncoder(); }

    //alterando o serviço de autenticação para usar o banco de dados que criamos
    // usa o Usuario
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(autenticacaoService).passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/auth").permitAll() // permite o acesso ao endpoint de autenticação
                    .antMatchers(HttpMethod.POST, "/auth/cadastrar").permitAll() // permite o acesso ao endpoint de autenticação
                .anyRequest().authenticated()
                // desabilita o csrf (necessário para o uso do token)
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // aceita apenas chamadas com o token
                .and()
                .addFilterBefore( // adicionar o filtro do token JWT
                        new AutenticacaoTokenFilter(tokenService, repository),
                        UsernamePasswordAuthenticationFilter.class
                );
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/auth").permitAll() // permite o acesso ao endpoint de autenticação
//                .antMatchers(HttpMethod.POST, "/auth/cadastrar").permitAll() // permite o acesso ao endpoint de autenticação
//                .and()
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and().csrf().disable() // desabilita o csrf (necessário para o uso do token)
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // aceita apenas chamadas com o token
//                .and()
//                .addFilterBefore( // adicionar o filtro do token JWT
//                        new AutenticacaoTokenFilter(tokenService, repository),
//                        UsernamePasswordAuthenticationFilter.class
//                );
//    }

    // removendo a configuração do WebSecurity padrão
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/auth");
    }
}
