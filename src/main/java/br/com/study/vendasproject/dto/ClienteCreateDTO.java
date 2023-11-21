package br.com.study.vendasproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteCreateDTO {

    @NotEmpty(message = "O campo nome não pode ser vazio")
    private String nome;

    @CPF(message = "CPF Inválido")
    private String cpf;
}
