package br.com.alura.Literalura.Principal;

import br.com.alura.Literalura.model.Autor;
import br.com.alura.Literalura.model.Livros;
import br.com.alura.Literalura.repository.LivrosRepository;
import br.com.alura.Literalura.service.ConsumoApi;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Scanner;

public class principal {

    public class Principal {
        private Scanner leitura = new Scanner(System.in);
        private ConsumoApi consumo = new ConsumoApi();
        private ConsumoApi.ConverteDados conversor = new ConsumoApi.ConverteDados();

        private final String URL_BASE = "https://gutendex.com/";

        public void exibeMenu() {
            var opcao = -1;

            while (opcao != 0) {
                var menu = """
                        *** Escolha o número de sua opção: ***
                        
                        1- Buscar livro pelo título
                        2- Listar livros registrados
                        3- Listar autores
                        4- Listar autores vivos em 1 determinado ano
                        5- Listar livros com 1 determinado idioma
                        0- Sair
                        """;
                System.out.println(menu);
                opcao = leitura.nextInt();
                leitura.nextLine();

                switch (opcao) {
                    case 1:
                        buscarLivroTitulo();
                        break;
                    case 2:
                        listarLivro();
                        break;
                    case 3:
                        listarAutores();
                        break;
                    case 4:
                        listarAutoresVivos();
                        break;
                    case 5:
                        listarLivrosIdioma();
                    case 0:
                        System.out.println("Encerrando a aplicação! ");
                        break;
                    default:
                        System.out.println("Opção inválida! ");


                }
            }
        }

        private void listarAutoresVivos() {
        }

        //opção 1 - Buscar livro pelo título
        private void buscarLivroTitulo() {
            System.out.println("Digite nome do livro: ");
            String nome = leitura.nextLine();
            List<Livros> livros = livrosRepository.findByTitulo(nome);
            if (!livros.isEmpty()) {
                System.out.println("Livro encontrado: ");
                livros.forEach(System.out::println);
            } else {
                System.out.println("Nenhum livro encontrado com esse título: ");
            }
        }

        //opção 2 - Listar livros registrados
        @Autowired
        private LivrosRepository livrosRepository;

        private void listarLivro() {
            List<Livros> livros = livrosRepository.findAll();
            livros.forEach(livro -> {
                System.out.println("ID: " + livro.getId());
                System.out.println("Título: " + livro.getTitle());
                System.out.println("Nome: " + livro.getName());

            });

        }

        //opção 3 - Listar autores

        private void listarAutores() {
            Scanner autorRepository = null;
            List<Autor> autores = autorRepository.findAll();
            for (Autor autor : autores) {
                System.out.println("Autor: " + autor.getNome());
                System.out.println("Ano de Nascimento: " + autor.getAnoNascimento());
                System.out.println("Ano de Morte: " + autor.getAnoMorte());
                System.out.println();
            }
        }


         //opção 4 - Listar autores vivos em um determinado ano
        //Incluiu o MeuServico para corrigir o autorRepository - ?????
         public class MeuServico {
             private final AutorRepository autorRepository;

             public MeuServico(AutorRepository autorRepository) {
                 this.autorRepository = autorRepository;
             }

             private void listarAutoresVivos() {
                 System.out.println("Digite o ano desejado com 4 dígitos: ");
                 int ano = Integer.parseInt(leitura.nextLine());
                 List<Autor> autores = autorRepository.findAutoresByAnoNascimento(ano);

                 if (!autores.isEmpty()) {
                     System.out.println("Autores vivos:");
                     autores.forEach(System.out::println);
                 } else {
                     System.out.println("Não há autores vivos nesse ano.");
                 }
             }

         }

        //opção 5 - Listar livros com 1 determinado idioma
        //informado o idioma ES, EN, FR, PT criar ENUM ???
        private void listarLivrosIdioma() {
            System.out.println("Digite idioma desejado ES, EN, FR ou PT: ");
            String idioma = leitura.nextLine();
            List<Livros> livros = livrosRepository.findByIdioma(idioma);

            if (!livros.isEmpty()) {
                System.out.println("Livros no idioma " + idioma + ":");
                livros.forEach(System.out::println);
            } else {
                System.out.println("Não foram encontrados livros no idioma " + idioma + ".");
            }
        }

    }
}

