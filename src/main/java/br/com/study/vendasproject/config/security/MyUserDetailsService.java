package br.com.study.vendasproject.config.security;

import br.com.study.vendasproject.domain.Usuario;
import br.com.study.vendasproject.enums.Role;
import br.com.study.vendasproject.rest.repository.UsuarioRepository;
import br.com.study.vendasproject.rest.service.AbstractBaseClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService extends AbstractBaseClass implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = this.usuarioRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(this.getMessage("usuario.not.found")));

        return User
                .builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles(Role.USER.toString())
                .build();
    }
}
