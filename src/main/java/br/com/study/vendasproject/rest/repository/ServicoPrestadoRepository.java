package br.com.study.vendasproject.rest.repository;

import br.com.study.vendasproject.domain.ServicoPrestado;
import br.com.study.vendasproject.dto.ServicoPrestadoResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Long> {

    @Query(
            " select sp from ServicoPrestado sp " +
                    "join sp.cliente c " +
                    "where UPPER(c.nome) like UPPER(CONCAT('%', :nome, '%')) " +
                    "or MONTH(sp.dataCadastro) = :mes"
    )
    public List<ServicoPrestado> findByClienteNomeAndMesServicoPrestado(
            @Param("nome") String clienteNome, @Param("mes") Integer mes);
}
