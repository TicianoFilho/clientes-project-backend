package br.com.study.vendasproject;

import br.com.study.vendasproject.domain.Cliente;
import br.com.study.vendasproject.repository.ClienteRepository;
import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientesProjectApplication {

	//Just for insert test
	@Bean
	public CommandLineRunner run (@Autowired ClienteRepository clienteRepository) {
		return args -> {
			Cliente cliente = Cliente.builder().cpf("11111111111").nome("Ticiano Filho").build();
			clienteRepository.save(cliente);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ClientesProjectApplication.class, args);
	}

}
