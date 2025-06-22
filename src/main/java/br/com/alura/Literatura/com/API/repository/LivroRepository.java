package br.com.alura.Literatura.com.API.repository;

import br.com.alura.Literatura.com.API.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro,Long> {
}
