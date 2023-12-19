package br.com.study.vendasproject.dto;

import br.com.study.vendasproject.domain.Cliente;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ServicoPrestadoCreateDTO {

    @NotEmpty(message = "{servico.prestado.field.descricao.required}")
    private String descricao;

    @JsonProperty("clienteId")
    @NotNull(message = "{servico.prestado.field.cliente.required}")
    private Long clienteCode;

    @NotNull(message = "{servico.prestado.field.valor.required}")
    private BigDecimal valor;
}
