package br.com.study.vendasproject.dto;

import br.com.study.vendasproject.domain.Cliente;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ServicoPrestadoCreateDTO {

    private String descricao;

    @JsonProperty("clienteId")
    private Long clienteCode;

    private BigDecimal valor;
}
