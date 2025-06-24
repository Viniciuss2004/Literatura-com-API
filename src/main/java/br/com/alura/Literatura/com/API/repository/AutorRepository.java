package br.com.alura.Literatura.com.API.repository;

import br.com.alura.Literatura.com.API.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor,Long> {

    Optional<Autor> findByNome(String nome);

    @Query("SELECT a FROM Autor a WHERE a.anoNascimento BETWEEN :inicio AND :fim AND a.anoFalecimento BETWEEN :inicio AND :fim")
    List<Autor> autoresEmDeterminadosAnos(@Param("inicio") Integer inicio, @Param("fim") Integer fim);

}
