package br.com.study.vendasproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponseDTO implements Serializable {

    private Long id;

    private String nome;

    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;
}
