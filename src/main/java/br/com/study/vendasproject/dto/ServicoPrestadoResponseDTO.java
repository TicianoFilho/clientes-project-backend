package br.com.study.vendasproject.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ServicoPrestadoResponseDTO {

    private Long id;

    private String descricao;

    private Long clienteId;

    private BigDecimal valor;

    private LocalDate dataCadastro;
}
