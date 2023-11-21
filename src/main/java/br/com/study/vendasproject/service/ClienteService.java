package br.com.study.vendasproject.service;

import br.com.study.vendasproject.domain.Cliente;
import br.com.study.vendasproject.dto.ClienteCreateDTO;
import br.com.study.vendasproject.dto.ClienteResponseDTO;
import br.com.study.vendasproject.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
}
