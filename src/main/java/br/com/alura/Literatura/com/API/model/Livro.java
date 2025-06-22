package br.com.alura.Literatura.com.API.model;

import jakarta.persistence.*;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @ManyToOne
    private Autor autor;

    @Column(unique = true)
    private String Idioma;
    private double numeroDownloads;

    public Livro() {}

    public Livro(String titulo, Autor autor, String idioma, double numeroDownloads) {
        this.titulo = titulo;
        this.autor = autor;
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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
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

    public void setNumeroDownloads(double numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + " | Autor: " + autor + " | Idioma: " + Idioma + " | Numero de downloads: " + numeroDownloads;
    }
}
