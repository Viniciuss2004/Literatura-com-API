package br.com.alura.Literatura.com.API.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResultadosBuscado(@JsonAlias("results") List<LivroDTO> livros) {
}
