package com.example.securityjwt.config;

import com.example.securityjwt.repository.UsuarioRepository;
import com.example.securityjwt.service.TokenService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutenticacaoTokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private final UsuarioRepository repository;

    public AutenticacaoTokenFilter(TokenService tokenService, UsuarioRepository repository) {
        this.tokenService = tokenService;
        this.repository = repository;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        String token = recuperarToken(request);
        boolean valido = tokenService.isTokenValid(token);
        if(valido) autenticarCliente(token);

        filterChain.doFilter(request,response);
    }

    private void autenticarCliente(String token) {
//        Long idUsuario = tokenService.getIdU
    }

    private String recuperarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token.isBlank() || !token.startsWith("Bearer")) return null;
        return token.substring(7);
    }


}
