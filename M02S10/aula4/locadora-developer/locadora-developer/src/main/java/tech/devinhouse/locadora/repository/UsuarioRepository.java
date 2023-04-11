package tech.devinhouse.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.devinhouse.locadora.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

  Optional<Usuario> findByEmail(String email);
}
