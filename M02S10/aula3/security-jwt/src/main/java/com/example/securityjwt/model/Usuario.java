package com.example.securityjwt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="usuario")
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Perfil> perfis = new ArrayList<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return perfis;
    }

    @Override
    public boolean isAccountNonExpired() { //define se a conta expira(false) ou não(true)
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {//define se a conta é travada(false) ou não(true)
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {//define se as credenciais expiram(false) ou não(true)
        return true;
    }

    @Override
    public boolean isEnabled() {// define se a conta está ativa ou não
        return true;
    }
}
