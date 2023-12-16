package br.com.study.vendasproject.rest.repository;

import br.com.study.vendasproject.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
