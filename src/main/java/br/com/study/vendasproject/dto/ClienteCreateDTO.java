package br.com.study.vendasproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteCreateDTO {

    @NotEmpty(message = "{cliente.field.nome.required}")
    private String nome;

    @CPF(message = "{cliente.field.cpf.invalid}")
    @NotEmpty(message = "{cliente.field.cpf.required}")
    private String cpf;
}
