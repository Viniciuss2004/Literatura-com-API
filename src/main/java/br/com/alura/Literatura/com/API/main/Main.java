package br.com.alura.Literatura.com.API.main;

import br.com.alura.Literatura.com.API.repository.AutorRepository;
import br.com.alura.Literatura.com.API.repository.LivroRepository;

import java.util.Scanner;

public class Main extends MetodosMain {
    private Scanner sc = new Scanner(System.in);

    public Main(AutorRepository autorRepository, LivroRepository livroRepository) {
        super(autorRepository, livroRepository);
    }

    public void app() throws InterruptedException {

        boolean continuar = true;
        while (continuar) {
            System.out.print("\u001B[32m========================= Menu =========================\u001B[0m\n\n" +
                    "1 - Buscar Livro Por Nome Ou Autor\n" +
                    "2 - Lista Livros Salvos\n" +
                    "3 - Listar Autores Salvos\n" +
                    "4 - Listar Autores Vivios Em Uma Determinado Ano\n" +
                    "5 - Listar Livros Em Um Determinado Idioma\n\n" +
                    "0 - Sair\n" +
                    "\nR: ");
            int opcao = sc.nextInt();
            sc.nextLine();
            System.out.println(" ");

            switch (opcao) {
                case 1:
                    buscarLivroPeloTituloOuAutor();
                    break;
                case 2:
                    listarLivrosSalvos();
                    break;
                case 3:
                    listarAutoresSalvos();
                    break;
                case 4:
                    listarAutoresEmDeterminadoAno();
                    break;
                case 5:
                    listarLivrosEmDeterminadosIdioma();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("Saindo...");
                    Thread.sleep(2000);
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        }
    }
}
