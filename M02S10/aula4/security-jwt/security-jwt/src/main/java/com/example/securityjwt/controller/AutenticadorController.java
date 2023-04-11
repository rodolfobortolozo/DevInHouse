package com.example.securityjwt.controller;

import com.example.securityjwt.controller.dto.LoginDto;
import com.example.securityjwt.controller.dto.TokenDto;
import com.example.securityjwt.controller.dto.UsuarioDto;
import com.example.securityjwt.model.Usuario;
import com.example.securityjwt.repository.PerfilRepository;
import com.example.securityjwt.repository.UsuarioRepository;
import com.example.securityjwt.service.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AutenticadorController {
    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final PerfilRepository perfilRepository;
    private final TokenService tokenService;

    public AutenticadorController(AuthenticationManager authenticationManager, UsuarioRepository usuarioRepository, PerfilRepository perfilRepository, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.perfilRepository = perfilRepository;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody @Valid LoginDto loginDto){
        UsernamePasswordAuthenticationToken login = loginDto.converter();
        try {
            Authentication authentication = authenticationManager.authenticate(login);
            String token = tokenService.gerarToken(authentication);
            return ResponseEntity.ok(new TokenDto(token, "Bearer")); // O Bearer é o tipo do token, acompanha os tokens JWT
        }catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid UsuarioDto usuarioDto){
        perfilRepository.save(usuarioDto.getPerfil());

        Usuario usuario = Usuario.builder()
                .username(usuarioDto.getUsername())
                .password(usuarioDto.getPassword())
                .perfis(List.of(usuarioDto.getPerfil()))
                .build();
        usuarioRepository.save(usuario);
        return ResponseEntity.created(URI.create("/auth/cadastro")).build();
    }
}
