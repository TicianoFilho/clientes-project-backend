package br.com.study.vendasproject.rest.resource;

import br.com.study.vendasproject.dto.UsuarioDTO;
import br.com.study.vendasproject.dto.UsuarioUsernameRequestDTO;
import br.com.study.vendasproject.rest.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioResource {

    private final UsuarioService usuarioService;

    public UsuarioResource(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> save(@RequestBody UsuarioDTO usuarioDTO) {
        return new ResponseEntity<>(this.usuarioService.save(usuarioDTO), HttpStatus.CREATED);q
    }

    @GetMapping("/get")
    public ResponseEntity<UsuarioDTO> getByUsername(@RequestBody UsuarioUsernameRequestDTO dto) {
        return new ResponseEntity<>(this.usuarioService.getByUsername(dto), HttpStatus.OK);
    }
}
