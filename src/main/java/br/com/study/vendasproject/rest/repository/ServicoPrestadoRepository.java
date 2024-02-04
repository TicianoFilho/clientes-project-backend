package br.com.study.vendasproject.rest.repository;

import br.com.study.vendasproject.domain.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Long> {

    @Query(
            " select sp from ServicoPrestado sp " +
                    "join sp.cliente c " +
                    "where UPPER(c.nome) like UPPER(CONCAT('%', :nome, '%')) " +
                    "and MONTH(sp.dataCadastro) = :mes"
    )
    List<ServicoPrestado> findByClienteNomeAndMesServicoPrestado(
            @Param("nome") String clienteNome, @Param("mes") Integer mes);

    @Query(value = "select coalesce(count(*), 0) from servico_prestado", nativeQuery = true)
    Integer getAllServicoPrestadoTotal();

    Optional<List<ServicoPrestado>> findAllByClienteId(Long clienteId);
}
