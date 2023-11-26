package br.com.study.vendasproject.rest.repository;

import br.com.study.vendasproject.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
