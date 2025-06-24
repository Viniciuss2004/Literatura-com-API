package br.com.alura.Literatura.com.API.dto;

import br.com.alura.Literatura.com.API.model.Autor;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record ListaAutoresDTO(@JsonAlias("authors") List<AutorDTO> autores) {

}
