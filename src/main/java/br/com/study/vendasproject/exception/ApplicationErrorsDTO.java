package br.com.study.vendasproject.exception;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

public class ApplicationErrorsDTO {

    @Getter
    private List<String> erros;

    public ApplicationErrorsDTO(List<String> errors) {
        this.erros = errors;
    }

    public ApplicationErrorsDTO(String message) {
        this.erros = Collections.singletonList(message);
    }
}
