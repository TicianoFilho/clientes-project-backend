package br.com.study.vendasproject.rest.resource;

import br.com.study.vendasproject.domain.Cliente;
import br.com.study.vendasproject.dto.cliente.ClienteCreateDTO;
import br.com.study.vendasproject.dto.cliente.ClienteDashboardDTO;
import br.com.study.vendasproject.dto.cliente.ClienteResponseDTO;
import br.com.study.vendasproject.exception.ClienteCannotBeDeletedException;
import br.com.study.vendasproject.rest.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
//@CrossOrigin(origins = {"http://127.0.0.1:4200", "http://localhost:4200"})
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
        try {
            return this.clienteService.delete(id);
        } catch (ClienteCannotBeDeletedException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> update(@PathVariable Long id, @Valid @RequestBody ClienteCreateDTO clienteCreateDTO) {
        return this.clienteService.update(id, clienteCreateDTO);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        return this.clienteService.getAll();
    }

    @GetMapping("/dashboard")
    public ResponseEntity<ClienteDashboardDTO> getDashboardInfo() {
        return new ResponseEntity<>(this.clienteService.getDashboardInfo(), HttpStatus.OK);
    }
}
