package tech.devinhouse.locadora.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.locadora.core.Security.JWTUtil;
import tech.devinhouse.locadora.model.Usuario;
import tech.devinhouse.locadora.repository.UsuarioRepository;

import java.util.Collections;
import java.util.Map;

@RestController // Marks the class a rest controller
@RequestMapping("/api/auth") // Requests made to /api/auth/anything will be handles by this class
public class AuthController {

  // Injecting Dependencies
  private final UsuarioRepository usuarioRepository;
  private final JWTUtil jwtUtil;
  private final AuthenticationManager authManager;
  private final PasswordEncoder passwordEncoder;

  public AuthController(UsuarioRepository usuarioRepository, JWTUtil jwtUtil, AuthenticationManager authManager, PasswordEncoder passwordEncoder) {
    this.usuarioRepository = usuarioRepository;
    this.jwtUtil = jwtUtil;
    this.authManager = authManager;
    this.passwordEncoder = passwordEncoder;
  }

  // Defining the function to handle the POST route for registering a user
  @PostMapping("/register")
  public Map<String, Object> registerHandler(@RequestBody Usuario usuario){

    String encodedPass = passwordEncoder.encode(usuario.getPassword());


    usuario.setPassword(encodedPass);

    usuario = usuarioRepository.save(usuario);

    String token = jwtUtil.generateToken(usuario.getEmail());


    return Collections.singletonMap("jwt-token", token);
  }


  @PostMapping("/login")
  public Map<String, Object> loginHandler(@RequestBody Usuario body){
    try {

      UsernamePasswordAuthenticationToken authInputToken =
              new UsernamePasswordAuthenticationToken(body.getEmail(), body.getPassword());


      authManager.authenticate(authInputToken);


      String token = jwtUtil.generateToken(body.getEmail());

      return Collections.singletonMap("jwt-token", token);
    }catch (AuthenticationException authExc){

      throw new RuntimeException("Credencais Inválidas");
    }
  }


}
