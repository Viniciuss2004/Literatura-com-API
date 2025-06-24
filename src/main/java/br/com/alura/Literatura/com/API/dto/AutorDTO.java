package br.com.alura.Literatura.com.API.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorDTO(@JsonAlias("name") String nome, @JsonAlias("birth_year") Integer anoNascimento, @JsonAlias("death_year") Integer anoFalecimento) {

    @Override
    public String toString() {
        return nome;
    }
}
