package br.com.study.vendasproject.rest.resource;

import br.com.study.vendasproject.dto.ServicoPrestadoCreateDTO;
import br.com.study.vendasproject.dto.ServicoPrestadoResponseDTO;
import br.com.study.vendasproject.rest.service.ServicoPrestadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/servicos-prestados")
//@CrossOrigin(origins = {"http://127.0.0.1:4200", "http://localhost:4200"})
public class ServicoPrestadoResource {

    private final ServicoPrestadoService servicoPrestadoService;

    @Autowired
    public ServicoPrestadoResource(ServicoPrestadoService servicoPrestadoService) {
        this.servicoPrestadoService = servicoPrestadoService;
    }

    @PostMapping
    public ResponseEntity<ServicoPrestadoResponseDTO> save(@Valid @RequestBody ServicoPrestadoCreateDTO servicoPrestadoCreateDTO) {
        return new ResponseEntity<ServicoPrestadoResponseDTO>(this.servicoPrestadoService.save(servicoPrestadoCreateDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ServicoPrestadoResponseDTO>> findByClienteNomeAndMesServicoPrestado(
            @RequestParam(value = "nomeCliente", required = false, defaultValue = "") String nomeCliente,
            @RequestParam(value = "mes", required = false) Integer mes
    ) {
        List<ServicoPrestadoResponseDTO> response = this.servicoPrestadoService.findByClienteNomeAndMesServicoPrestado(nomeCliente, mes);
        return new ResponseEntity<List<ServicoPrestadoResponseDTO>>(response, HttpStatus.OK);
    }


}
