package br.com.alura.Literatura.com.API.main;

import br.com.alura.Literatura.com.API.dto.ResultadosBuscado;
import br.com.alura.Literatura.com.API.model.Autor;
import br.com.alura.Literatura.com.API.model.Livro;
import br.com.alura.Literatura.com.API.repository.AutorRepository;
import br.com.alura.Literatura.com.API.repository.LivroRepository;
import br.com.alura.Literatura.com.API.service.ConsumoApi;
import br.com.alura.Literatura.com.API.service.ConverteDados;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MetodosMain {
    Scanner sc = new Scanner(System.in);

    ConsumoApi consumirApi = new ConsumoApi();
    ConverteDados converteDados = new ConverteDados();
    private final String ENDERECO = "http://gutendex.com/books/?";

    AutorRepository autorRepository;
    LivroRepository livroRepository;

    public MetodosMain(AutorRepository autorRepository, LivroRepository livroRepository) {
        this.autorRepository = autorRepository;
        this.livroRepository = livroRepository;
    }

    public void buscarLivroPeloTituloOuAutor() {

        System.out.println("Digite o titulo do livro: ");
        String titulo = sc.nextLine().toLowerCase().replaceAll(" ", "+");

        try {
            String json = consumirApi.obterDados(ENDERECO + "search=" + titulo);

            ResultadosBuscado listaLivros = converteDados.obterDados(json, new TypeReference<>() {
            });

            if (listaLivros.livros().size() > 1) {
                System.out.println("\nEscolha o livro pelo ID para salvar no banco de dados: ");
                int id = sc.nextInt();
                sc.nextLine();

                json = consumirApi.obterDados(ENDERECO + "ids=" + id);

                listaLivros = converteDados.obterDados(json, new TypeReference<>() {
                });

                salvarLivrosEAutores(listaLivros);

            } else {
                salvarLivrosEAutores(listaLivros);
            }
        } catch (NoSuchElementException e) {
            System.out.println("\u001B[32m Nome não encontrado\u001B[0m");;
        }
    }

    public void salvarLivrosEAutores(ResultadosBuscado json) {

        Livro livro = json.livros()
                .stream()
                .map(ld -> new Livro(ld.titulo(), String.join(", ", ld.idiomas()), ld.numeroDownloads()))
                .toList().getFirst();

        List<Autor> autores = json.livros().getFirst().autores()
                .stream()
                .map(a -> {
                    // Verifica se o autor já existe no banco pelo nome
                    return autorRepository.findByNome(a.nome())
                            .orElseGet(() -> autorRepository.save(new Autor(a.nome(), a.anoNascimento(), a.anoFalecimento())));
                })
                .collect(Collectors.toList());

        livro.setAutor(autores);

        livroRepository.save(livro);

        System.out.println("\nLivros e Autores salvos!");
    }

    public void listarLivrosSalvos() {

        System.out.print("\u001B[32m========================= Livros Salvos =========================\u001B[0m\n\n");

        List<Livro> livros = livroRepository.livrosSalvos();
        livros.stream()
                .sorted(Comparator.comparing(Livro::getTitulo))
                .forEach(System.out::println);

        System.out.println(" ");
    }

    public void listarAutoresSalvos() {

        System.out.print("\u001B[32m========================= Autores Salvos =========================\u001B[0m\n\n");

        List<Autor> autores = autorRepository.findAll();
        autores.stream()
                .sorted(Comparator.comparing(Autor::getNome))
                .forEach(System.out::println);

        System.out.println(" ");
    }

    public void listarAutoresEmDeterminadoAno() {

        System.out.print("Digite o Ano de nascimento do Autor: ");
        int anoNascimento = sc.nextInt();
        sc.nextLine();

        System.out.print("\nDigite o Ano de falecimento do Autor: ");
        int anoFalecimento = sc.nextInt();
        sc.nextLine();

        System.out.print("\n\u001B[32m========================= Autores Buscado Por Determinado Anos =========================\u001B[0m\n\n");

        List<Autor> autores = autorRepository.autoresEmDeterminadosAnos(anoNascimento, anoFalecimento);
        autores.stream()
                .sorted(Comparator.comparing(Autor::getAnoNascimento))
                .forEach(System.out::println);

        System.out.println(" ");
    }

    public void listarLivrosEmDeterminadosIdioma() {
        String idiomas = String.join(", ", livroRepository.buscarTodosIdiomas());

        System.out.print("Escolha um desses idiomas disponiveis (" + idiomas + "): ");
        String idiomaEscolhido = sc.nextLine().toLowerCase().trim();

        System.out.print("\n\u001B[32m========================= Livros Buscado Por Idioma =========================\u001B[0m\n\n");

        List<Livro> livros = livroRepository.buscarLivrosPorIdioma(idiomaEscolhido);

        livros.stream()
                .sorted(Comparator.comparing(Livro::getTitulo))
                .forEach(System.out::println);

        System.out.println(" ");
    }
}
