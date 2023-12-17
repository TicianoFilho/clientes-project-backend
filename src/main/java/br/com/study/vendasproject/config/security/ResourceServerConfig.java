package br.com.study.vendasproject.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Value("${api.base.path}")
    private String apiBasePath;
    @Override
    public void configure(HttpSecurity http) throws Exception {
        // Configurações relativas aos Resources
        http
                .authorizeRequests()
                .antMatchers(apiBasePath + "/api/v1/usuarios").permitAll()
                .antMatchers(apiBasePath + "/api/v1/clientes/**", apiBasePath + "/api/v1/servicos-prestados/**").authenticated()
                .anyRequest().denyAll();
    }
}
