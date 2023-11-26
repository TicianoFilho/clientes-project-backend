package br.com.study.vendasproject.dto;

import br.com.study.vendasproject.domain.Cliente;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ServicoPrestadoCreateDTO {

    private String descricao;

    private Cliente cliente;

    private BigDecimal valor;
}
