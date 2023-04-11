package tech.devinhouse.locadora.core.Security;

// A UserDetailsService is used to fetch the user details of the user trying to authenticate
// into the application. This is done in the loadUserByUsername method.
// If no such user is found a UsernameNotFoundException is thrown

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import tech.devinhouse.locadora.model.Usuario;
import tech.devinhouse.locadora.repository.UsuarioRepository;

import java.util.Collections;
import java.util.Optional;

@Component

public class MyUserDetailsService implements UserDetailsService {

  private final UsuarioRepository usuarioRepository;

  public MyUserDetailsService(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Optional<Usuario> userRes = usuarioRepository.findByEmail(email);

    if(userRes.isEmpty())
      throw new UsernameNotFoundException("Could not findUser with email = " + email);

    Usuario user = userRes.get();
    return new org.springframework.security.core.userdetails.User(
            email,
            user.getPassword(),
            Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))); // Sets the role of the found user
  }
}
