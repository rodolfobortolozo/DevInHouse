package com.example.securityjwt.service;

import com.example.securityjwt.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${security.jwt.expiration}")
    private Long tempoExpiracao;

    @Value("${security.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authentication){
        Usuario user = (Usuario) authentication.getPrincipal();
        Date hoje = new Date();
        Date expiracao = new Date();

        expiracao.setTime(hoje.getTime() + tempoExpiracao);

        return Jwts.builder()
                .setIssuer("Security JWT")
                .setSubject(String.valueOf(user.getId()))
                .setIssuedAt(hoje)
                .setExpiration(expiracao)
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();

    }

    public boolean isTokenValid(String token){
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public Long getIdUsuario(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
