package br.com.study.vendasproject.rest;

import br.com.study.vendasproject.dto.ClienteCreateDTO;
import br.com.study.vendasproject.dto.ClienteResponseDTO;
import br.com.study.vendasproject.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteResource {

    private final ClienteService clienteService;

    @Autowired
    public ClienteResource(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponseDTO save(@RequestBody ClienteCreateDTO clienteCreateDTO) {
        return this.clienteService.save(clienteCreateDTO).getBody();
    }
}
