package br.com.study.vendasproject.rest.service;

import br.com.study.vendasproject.domain.Usuario;
import br.com.study.vendasproject.dto.UsuarioDTO;
import br.com.study.vendasproject.rest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends AbstractBaseClass {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        Usuario usuario = mapper.map(usuarioDTO, Usuario.class);
        return mapper.map(this.usuarioRepository.save(usuario), UsuarioDTO.class);
    }

}
