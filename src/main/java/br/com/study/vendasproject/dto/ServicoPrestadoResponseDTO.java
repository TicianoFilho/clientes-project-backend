package br.com.study.vendasproject.dto;

import br.com.study.vendasproject.domain.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ServicoPrestadoResponseDTO {

    private Long id;

    private String descricao;

    private ClienteResponseDTO cliente;

    private BigDecimal valor;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    public ServicoPrestadoResponseDTO(Long id, String descricao, ClienteResponseDTO cliente, BigDecimal valor, LocalDate dataCadastro) {
        this.id = id;
        this.descricao = descricao;
        this.cliente = cliente;
        this.valor = valor;
        this.dataCadastro = dataCadastro;
    }
}
