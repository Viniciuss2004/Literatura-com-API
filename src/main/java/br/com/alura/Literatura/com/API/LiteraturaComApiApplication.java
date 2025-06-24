package br.com.alura.Literatura.com.API;

import br.com.alura.Literatura.com.API.main.Main;
import br.com.alura.Literatura.com.API.repository.AutorRepository;
import br.com.alura.Literatura.com.API.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraturaComApiApplication implements CommandLineRunner {

	@Autowired
	AutorRepository autorRepository;

	@Autowired
	LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiteraturaComApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(autorRepository, livroRepository);
		main.app();
	}
}
