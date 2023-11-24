package br.com.study.vendasproject.rest;

import br.com.study.vendasproject.domain.Cliente;
import br.com.study.vendasproject.dto.ClienteCreateDTO;
import br.com.study.vendasproject.dto.ClienteResponseDTO;
import br.com.study.vendasproject.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
@CrossOrigin(origins = {"http://127.0.0.1:4200", "http://localhost:4200"})
public class ClienteResource {

    private final ClienteService clienteService;

    @Autowired
    public ClienteResource(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteResponseDTO save(@Valid @RequestBody ClienteCreateDTO clienteCreateDTO) {
        return this.clienteService.save(clienteCreateDTO).getBody();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> findById(@PathVariable Long id) {
        return this.clienteService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return this.clienteService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> update(@PathVariable Long id, @Valid @RequestBody ClienteCreateDTO clienteCreateDTO) {
        return this.clienteService.update(id, clienteCreateDTO);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        return this.clienteService.getAll();
    }
}
