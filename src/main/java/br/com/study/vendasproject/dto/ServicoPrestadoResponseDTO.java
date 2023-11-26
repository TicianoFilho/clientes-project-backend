package br.com.study.vendasproject.dto;

import br.com.study.vendasproject.domain.Cliente;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ServicoPrestadoResponseDTO {

    private Long id;

    private String descricao;

    private Cliente cliente;

    private BigDecimal valor;

    private LocalDate dataCadastro;
}
