package br.com.study.vendasproject.rest.repository;

import br.com.study.vendasproject.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value = "select coalesce(count(*), 0) from cliente", nativeQuery = true)
    Integer getAllCustomersTotal();
}
