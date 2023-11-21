package br.com.study.vendasproject.dto;

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

    private LocalDate dataCadastro;
}
