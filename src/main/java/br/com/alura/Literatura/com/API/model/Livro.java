package br.com.alura.Literatura.com.API.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "livro_autor",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autor;

    private String Idioma;
    private Integer numeroDownloads;

    public Livro() {}

    public Livro(String titulo, String idioma, Integer numeroDownloads) {
        this.titulo = titulo;
        Idioma = idioma;
        this.numeroDownloads = numeroDownloads;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return Idioma;
    }

    public void setIdioma(String idioma) {
        Idioma = idioma;
    }

    public double getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(Integer numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    @Override
    public String toString() {

        String autores = autor.stream()
                .map(Autor::getNome)
                .collect(Collectors.joining(", "));

        return "Título: " + titulo + " | Autor: " + autores + " | Idioma: " + Idioma + " | Numero de downloads: " + numeroDownloads;
    }
}
