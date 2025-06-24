package br.com.alura.Literatura.com.API.dto;

import br.com.alura.Literatura.com.API.model.Autor;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroDTO(@JsonAlias("id") Integer id, @JsonAlias("title") String titulo, @JsonAlias("authors") List<AutorDTO> autores, @JsonAlias("languages") List<String> idiomas, @JsonAlias("download_count") Integer numeroDownloads) {

    @Override
    public String toString() {
        return "Id Livro: " + id + " | Título: " + titulo + " | Autor: " + autores + " | Idioma: " + idiomas + " | Numero de downloads: " + numeroDownloads;
    }
}
