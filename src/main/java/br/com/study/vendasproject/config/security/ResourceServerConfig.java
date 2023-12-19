package br.com.study.vendasproject.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // Configurações relativas aos Resources
        http
                .authorizeRequests()
                .antMatchers("/api/v1/clientes/**").authenticated()
                .antMatchers("/api/v1/servicos-prestados/**").authenticated()
                .antMatchers("/api/v1/usuarios/**").permitAll()

                .anyRequest().denyAll();
    }
}
