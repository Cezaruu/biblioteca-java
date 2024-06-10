package view;

import controller.BibliotecaController;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import model.Bibliotecario;
import model.Emprestimo;
import model.Estudante;
import model.Livro;
import model.Professor;
import model.Usuario;

public class Main {
    public static void main(String[] args) {
        // Inicializando o controlador da biblioteca
        BibliotecaController controller = new BibliotecaController();

        // Criando e adicionando um bibliotecário
        Bibliotecario bibliotecario = new Bibliotecario("João Silva", "12345678900", "1234", LocalDate.of(1980, 5, 20), "joao", "senha123");

        // Autenticando o bibliotecário
        signIn(bibliotecario, controller);
    }

    private static void signIn(Bibliotecario bibliotecario, BibliotecaController controller) {
        String usuario;
        String senha;
        try (Scanner input = new Scanner(System.in)) {
            System.out.println(" --- Login Bibliotecário --- ");

            System.out.print("Login: ");
            usuario = input.nextLine();

            while (!usuario.equals(bibliotecario.getLogin())) {
                System.out.print("Digite corretamente o login: ");
                usuario = input.nextLine();
            }

            System.out.print("Senha: ");
            senha = input.nextLine();

            while (!senha.equals(bibliotecario.getSenha())) {
                System.out.print("Digite corretamente a senha: ");
                senha = input.nextLine();
            }

            System.out.println("Login bem-sucedido!");
            realizarOperacoes(controller, input);
        }
    }

    private static void realizarOperacoes(BibliotecaController controller, Scanner input) {
        while (true) {
            System.out.println("Digite um comando (help para ver as opções, exit para sair): ");
            String comando = input.nextLine().trim().toLowerCase();

            switch (comando) {
                case "help":
                    mostrarOpcoes();
                    break;
                case "adicionar usuario":
                    adicionarUsuario(controller, input);
                    break;
                case "adicionar livro":
                    adicionarLivro(controller, input);
                    break;
                case "listar livros":
                    listarLivros(controller);
                    break;
                case "listar usuarios":
                    listarUsuarios(controller);
                    break;
                case "remover livro":
                    removerLivro(controller, input);
                    break;
                case "remover usuario":
                    removerUsuario(controller, input);
                    break;
                case "exit":
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Comando não reconhecido.");
            }
        }
    }

    private static void mostrarOpcoes() {
        System.out.println("Opções disponíveis:");
        System.out.println("adicionar usuario - Adicionar um novo usuário");
        System.out.println("adicionar livro - Adicionar um novo livro");
        System.out.println("listar livros - Listar todos os livros");
        System.out.println("listar usuarios - Listar todos os usuários");
        System.out.println("remover livro - Remover um livro pelo título");
        System.out.println("remover usuario - Remover um usuário pelo CPF");
    }

    private static void adicionarUsuario(BibliotecaController controller, Scanner input) {
        System.out.println("Digite o nome do usuário: ");
        String nome = input.nextLine();
        System.out.println("Digite o CPF do usuário: ");
        String cpf = input.nextLine();
        System.out.println("Digite a matrícula do usuário: ");
        String matricula = input.nextLine();
        System.out.println("Digite a data de nascimento (YYYY-MM-DD): ");
        LocalDate dataNascimento = LocalDate.parse(input.nextLine());

        // Determinar tipo de usuário
        System.out.println("Tipo de usuário (estudante/professor): ");
        String tipo = input.nextLine().toLowerCase();

        Usuario usuario;
        switch (tipo) {
            case "estudante":
                System.out.println("Digite o curso: ");
                String curso = input.nextLine();
                usuario = new Estudante(nome, cpf, matricula, dataNascimento, curso);
                break;
            case "professor":
                System.out.println("Digite o departamento: ");
                String departamento = input.nextLine();
                usuario = new Professor(nome, cpf, matricula, dataNascimento, departamento);
                break;
            default:
                System.out.println("Tipo de usuário inválido.");
                return;
        }

        controller.adicionarUsuario(usuario);
        System.out.println("Usuário adicionado com sucesso.");
    }

    private static void adicionarLivro(BibliotecaController controller, Scanner input) {
        System.out.println("Digite o título do livro: ");
        String titulo = input.nextLine();
        System.out.println("Digite o autor do livro: ");
        String autor = input.nextLine();
        System.out.println("Digite o gênero do livro: ");
        String genero = input.nextLine();
        System.out.println("Digite o ano de publicação: ");
        int anoPublicacao = Integer.parseInt(input.nextLine());
        System.out.println("Digite a quantidade disponível: ");
        int quantidade = Integer.parseInt(input.nextLine());

        Livro livro = new Livro(titulo, autor, genero, anoPublicacao, quantidade);
        controller.adicionarLivro(livro);
        System.out.println("Livro adicionado com sucesso.");
    }

    private static void listarLivros(BibliotecaController controller) {
        List<Livro> livros = controller.pesquisarLivrosPorAutor(""); // Lista todos os livros
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            System.out.println("Livros cadastrados:");
            for (Livro livro : livros) {
                System.out.println(livro.getTitulo() + " por " + livro.getAutor());
            }
        }
    }

    private static void listarUsuarios(BibliotecaController controller) {
        List<Usuario> usuarios = controller.bancoDAO.getUsuarios();
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            System.out.println("Usuários cadastrados:");
            for (Usuario usuario : usuarios) {
                System.out.println(usuario.getNome() + " - " + usuario.getCpf());
            }
        }
    }

    private static void removerLivro(BibliotecaController controller, Scanner input) {
        System.out.println("Digite o título do livro a ser removido: ");
        String titulo = input.nextLine();
        Livro livro = controller.pesquisarLivroPorTitulo(titulo);
        if (livro != null) {
            controller.removerLivro(livro);
            System.out.println("Livro removido com sucesso.");
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    private static void removerUsuario(BibliotecaController controller, Scanner input) {
        System.out.println("Digite o CPF do usuário a ser removido: ");
        String cpf = input.nextLine();
        Usuario usuario = controller.verificarSituacaoUsuario(cpf);
        if (usuario != null) {
            controller.removerUsuario(usuario);
            System.out.println("Usuário removido com sucesso.");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }
}
