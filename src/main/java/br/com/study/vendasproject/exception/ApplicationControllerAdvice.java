package br.com.study.vendasproject.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApplicationErrorsDTO handleValidationErros(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<String> messages = bindingResult.getAllErrors()
                .stream()
                .map(objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());
        return new ApplicationErrorsDTO(messages);
    }

    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity handleValidationErros(ResponseStatusException ex) {
        String errorMessage = ex.getReason();
        HttpStatus statusCode = ex.getStatus();
        ApplicationErrorsDTO errorsDTO = new ApplicationErrorsDTO(errorMessage);
        return new ResponseEntity(errorsDTO, statusCode);
    }

    @ExceptionHandler(UsuarioNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity handleValidationErros(UsuarioNotFoundException ex) {
        String errorMessage = ex.getMessage();
        HttpStatus statusCode = HttpStatus.NOT_FOUND;
        ApplicationErrorsDTO errorsDTO = new ApplicationErrorsDTO(errorMessage);
        return new ResponseEntity(errorsDTO, statusCode);
    }
}
