package br.com.study.vendasproject.rest.service;

import br.com.study.vendasproject.domain.Cliente;
import br.com.study.vendasproject.dto.ClienteCreateDTO;
import br.com.study.vendasproject.dto.ClienteResponseDTO;
import br.com.study.vendasproject.rest.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService extends AbstractBaseClass {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ResponseEntity<ClienteResponseDTO> save(ClienteCreateDTO clienteCreateDTO) {
        Cliente cliente = mapper.map(clienteCreateDTO, Cliente.class);
        return new ResponseEntity<>(mapper.map(clienteRepository.save(cliente), ClienteResponseDTO.class), HttpStatus.CREATED);
    }

    public ResponseEntity<ClienteResponseDTO> findById(Long id) {
        Cliente cliente = this.clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, this.getMessage("cliente.not.found")));
        return new ResponseEntity<>(mapper.map(cliente, ClienteResponseDTO.class), HttpStatus.OK);
    }

    public ResponseEntity<Void> delete(Long id) {
        Cliente clienteToDelete = clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, this.getMessage("cliente.not.found")));
        clienteRepository.delete(clienteToDelete);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<ClienteResponseDTO> update(Long id, @RequestBody ClienteCreateDTO clienteCreateDTO) {
        Cliente clienteToUpdate = clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, this.getMessage("cliente.not.found")));
        mapper.map(clienteCreateDTO, clienteToUpdate);
        Cliente clienteUpdated = clienteRepository.save(clienteToUpdate);
        return ResponseEntity.ok(mapper.map(clienteUpdated, ClienteResponseDTO.class));
    }

    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok(this.clienteRepository.findAll());
    }

    public Cliente findEntityById(Long id) throws Exception {
        return this.clienteRepository
                .findById(id)
                .orElseThrow(() -> new Exception(this.getMessage("cliente.not.found")));
    }
}
