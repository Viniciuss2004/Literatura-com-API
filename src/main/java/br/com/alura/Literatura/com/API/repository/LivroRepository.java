package br.com.alura.Literatura.com.API.repository;

import br.com.alura.Literatura.com.API.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("SELECT l FROM Livro l JOIN FETCH l.autor")
    List<Livro> livrosSalvos();

    @Query("SELECT DISTINCT l.Idioma FROM Livro l")
    List<String> buscarTodosIdiomas();

    @Query("SELECT l FROM Livro l WHERE l.Idioma = :idioma ")
    List<Livro> buscarLivrosPorIdioma(@Param("idioma") String idiomaEscolhido);
}
