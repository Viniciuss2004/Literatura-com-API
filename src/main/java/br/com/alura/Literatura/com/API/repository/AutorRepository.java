package br.com.alura.Literatura.com.API.repository;

import br.com.alura.Literatura.com.API.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor,Long> {
}
