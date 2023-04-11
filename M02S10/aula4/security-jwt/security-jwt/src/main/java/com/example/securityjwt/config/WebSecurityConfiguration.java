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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final TokenService tokenService;
    private final UsuarioRepository repository;
    private final AutenticacaoService autenticacaoService;
    private final DataSource dataSource;

    public WebSecurityConfiguration(TokenService tokenService, UsuarioRepository repository, AutenticacaoService autenticacaoService, DataSource dataSource) {
        this.tokenService = tokenService;
        this.repository = repository;
        this.autenticacaoService = autenticacaoService;
        this.dataSource = dataSource;
    }

    // traz o gerenciado de autenticação para dentro do programa
    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManager();
    }

    // criar o formato padrão de encriptação da senhas
    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
    // 12345jahsgdjkhagdhjgahjsgdhjgashjdgjhasghjdgajhsgdhjagds


    // alterando o serviço de autecação para usar o banco de dados que criamos
    // usa o Usuario
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(autenticacaoService).passwordEncoder(encoder());
    }


    @Override
    public void configure(HttpSecurity http) throws Exception{
        http

                .cors().and().csrf().disable().headers().frameOptions().disable()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Apenas aceita chamada com o token
                .and()
                .authorizeRequests()//desabilita o csrf, é necessário para o uso do token
                .antMatchers("/auth").permitAll()//permite o acesso do endpoint do token
                .antMatchers("/auth/cadastro").permitAll()//permite o acesso do endpoint do token
                .anyRequest().authenticated() //todos os demais endpoints precisam de ter autenticação, adição do token
                .and().authorizeRequests().anyRequest().authenticated()
                .and()
                .addFilterBefore(
                        new AutenticacaoTokenFilter(tokenService, repository), // adicionar o filtro do token JWT
                        UsernamePasswordAuthenticationFilter.class
                );
    }

    // removendo a configuração do WebSecurity padrão
    @Override
    public void configure(WebSecurity web) throws  Exception{

    }

}
