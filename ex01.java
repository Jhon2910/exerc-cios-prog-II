import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ex01{
    private static List<Livro> estoque = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    static class Livro {
        String nome;
        String autor;
        int ano;
        String descricao;
        double preco;

        Livro(String nome, String autor, int ano, String descricao, double preco) {
            this.nome = nome;
            this.autor = autor;
            this.ano = ano;
            this.descricao = descricao;
            this.preco = preco;
        }
    }

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Digite apenas números!");
                scanner.nextLine();
                opcao = 0;
            }

            if (opcao == 1) {
                cadastrarLivro();
            } else if (opcao == 2) {
                listarLivros();
            } else if (opcao == 3) {
                System.out.println("Saindo... até logo!");
            } else {
                System.out.println("Opção inválida!");
            }

        } while (opcao != 3);
    }

    private static void exibirMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Cadastrar Livro");
        System.out.println("2. Listar Livros");
        System.out.println("3. Sair");
    }

    private static void cadastrarLivro() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        System.out.print("Ano: ");
        int ano = scanner.hasNextInt() ? scanner.nextInt() : 0;
        scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Preço: ");
        double preco = scanner.hasNextDouble() ? scanner.nextDouble() : 0.0;
        scanner.nextLine();

        estoque.add(new Livro(nome, autor, ano, descricao, preco));
        System.out.println("Livro cadastrado!");
    }

    private static void listarLivros() {
        if (estoque.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        System.out.println("\n--- Livros ---");
        for (int i = 0; i < estoque.size(); i++) {
            Livro l = estoque.get(i);
            System.out.println((i + 1) + ") " + l.nome + " - " + l.autor + " (" + l.ano + ")");
            System.out.println("Descrição: " + l.descricao);
            System.out.println("Preço: R$ " + l.preco);
            System.out.println("-------------------");
        }
    }
}
