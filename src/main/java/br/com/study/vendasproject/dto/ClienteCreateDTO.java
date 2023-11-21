package br.com.study.vendasproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteCreateDTO {

    private String nome;

    private String cpf;
}
