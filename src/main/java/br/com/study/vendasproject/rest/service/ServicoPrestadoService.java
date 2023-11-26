package br.com.study.vendasproject.rest.service;

import br.com.study.vendasproject.domain.Cliente;
import br.com.study.vendasproject.domain.ServicoPrestado;
import br.com.study.vendasproject.dto.ServicoPrestadoCreateDTO;
import br.com.study.vendasproject.dto.ServicoPrestadoResponseDTO;
import br.com.study.vendasproject.exception.ServicoPrestadoException;
import br.com.study.vendasproject.rest.repository.ServicoPrestadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoPrestadoService extends AbstractBaseClass {

    private final ServicoPrestadoRepository servicoPrestadoRepository;
    private final ClienteService clienteService;

    @Autowired
    public ServicoPrestadoService(ServicoPrestadoRepository servicoPrestadoRepository, ClienteService clienteService) {
        this.servicoPrestadoRepository = servicoPrestadoRepository;
        this.clienteService = clienteService;
    }

    public ServicoPrestadoResponseDTO save(ServicoPrestadoCreateDTO servicoPrestadoCreateDTO) {
        ServicoPrestadoResponseDTO servicoPrestadoResponseDTO = new ServicoPrestadoResponseDTO();
        try {
            Cliente cliente = this.clienteService.findEntityById(servicoPrestadoCreateDTO.getCliente().getId());
            ServicoPrestado servicoPrestado = mapper.map(servicoPrestadoCreateDTO, ServicoPrestado.class);
            servicoPrestado.setCliente(cliente);
            servicoPrestadoRepository.save(servicoPrestado);
            servicoPrestadoResponseDTO = mapper.map(servicoPrestado, ServicoPrestadoResponseDTO.class);
        } catch(Exception e) {
            throw new ServicoPrestadoException(this.getMessage("servico.prestado.create.error"));
        }
        return servicoPrestadoResponseDTO;
    }
}