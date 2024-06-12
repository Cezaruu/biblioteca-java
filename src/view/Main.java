package view;

import controller.BibliotecaController;
import exception.EmprestimosExcedidos;
import exception.LivrosEmprestado;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import model.Bibliotecario;
import model.Estudante;
import model.Livro;
import model.Professor;
import model.Usuario;

public class Main{
    public static void main(String[] args){
        BibliotecaController controller = new BibliotecaController();

        controller.adicionarUsuario(new Estudante("Joao", "11111111111", "2022001", LocalDate.of(2004, 1, 15), "Engenharia"));
        controller.adicionarUsuario(new Estudante("Victor", "22222222222", "2022004", LocalDate.of(2004, 2, 18), "TI"));
        controller.adicionarUsuario(new Estudante("Tiago", "33333333333", "2022002", LocalDate.of(2003, 6, 7), "C&T"));
        controller.adicionarUsuario(new Professor("Gustavo", "44444444444", "P2022001", LocalDate.of(1980, 2, 20), "C&T"));
        controller.adicionarUsuario(new Professor("Danillo", "55555555555", "P2022002", LocalDate.of(1981, 5, 5), "Geografia"));
        controller.adicionarUsuario(new Bibliotecario("Paulo Cezar", "12345678901", "1234", LocalDate.of(1980, 5, 20), "paulo", "senha123"));

        controller.adicionarLivro(new Livro("Dom Quixote", "Miguel de Cervantes", "Romance de cavalaria", 1605, 5));
        controller.adicionarLivro(new Livro("One Piece", "Eiichiro Oda", "Aventura", 1998, 6));
        controller.adicionarLivro(new Livro("Valhaisen", "Landinus", "Aventura", 2024, 4));
        controller.adicionarLivro(new Livro("Amazing Fantasy #15", "Stan Lee", "Quadrinhos, super-heróis", 1962, 3));
        controller.adicionarLivro(new Livro("Naruto", "Kishimoto", "Ninja", 1999, 8));

        signIn(new Bibliotecario("Paulo Cezar", "12345678901", "1234", LocalDate.of(2003, 11, 20), "paulo", "senha123"), controller);
    }
    private static void signIn(Bibliotecario bibliotecario, BibliotecaController controller){
        String usuario;
        String senha;
        try (Scanner input = new Scanner(System.in)){
            System.out.println(" --- Login Bibliotecário --- ");
            System.out.print("Login: ");
            usuario = input.nextLine();
            while (!usuario.equals(bibliotecario.getLogin())){
                System.out.print("Digite corretamente o login: ");
                usuario = input.nextLine();
            }
            System.out.print("Senha: ");
            senha = input.nextLine();
            while (!senha.equals(bibliotecario.getSenha())){
                System.out.print("Digite corretamente a senha: ");
                senha = input.nextLine();
            }
            System.out.println("\nLogin bem-sucedido!\n");
            realizarOperacoes(controller, input);
        }
    }
    private static void realizarOperacoes(BibliotecaController controller, Scanner input){
        while (true){
            System.out.println("Digite um comando (help para ver as opções, exit para sair): \n");
            String comando = input.nextLine().trim().toLowerCase();
            switch (comando){
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
                case "realizar emprestimo":
                    realizarEmprestimo(controller, input);
                    break;
                case "remover livro":
                    removerLivro(controller, input);
                    break;
                case "remover usuario":
                    removerUsuario(controller, input);
                    break;
                case "exit":
                    System.out.println("\nSaindo...\n");
                    return;
                default:
                    System.out.println("\nComando não reconhecido.\n");
                    break;
            }
        }
    }
    private static void mostrarOpcoes(){
        System.out.println("\n");
        System.out.println("Opções disponíveis:\n");
        System.out.println("adicionar usuario - Adicionar um novo usuário");
        System.out.println("adicionar livro - Adicionar um novo livro");
        System.out.println("listar livros - Listar todos os livros");
        System.out.println("listar usuarios - Listar todos os usuários");
        System.out.println("realizar emprestimo - Realizar empréstimo de um livro");
        System.out.println("remover livro - Remover um livro pelo título");
        System.out.println("remover usuario - Remover um usuário pelo CPF");
    }
    private static void adicionarUsuario(BibliotecaController controller, Scanner input){
        System.out.println("\n");
        System.out.println("Digite o nome do usuário: ");
        String nome = input.nextLine();
        System.out.println("Digite o CPF do usuário: ");
        String cpf = input.nextLine();
        System.out.println("Digite a matrícula do usuário: ");
        String matricula = input.nextLine();
        System.out.println("Digite a data de nascimento (YYYY-MM-DD): ");
        LocalDate dataNascimento = LocalDate.parse(input.nextLine());
        System.out.println("Tipo de usuário (estudante/professor): ");
        String tipo = input.nextLine().toLowerCase();
        Usuario usuario;
        switch (tipo){
            case "estudante":
                System.out.println("Digite o curso:");
                String curso = input.nextLine();
                usuario = new Estudante(nome, cpf, matricula, dataNascimento, curso);
                break;
            case "professor":
                System.out.println("Digite o departamento:");
                String departamento = input.nextLine();
                usuario = new Professor(nome, cpf, matricula, dataNascimento, departamento);
                break;
            default:
                System.out.println("\nTipo de usuário inválido.\n");
                return;
        }
        controller.adicionarUsuario(usuario);
        System.out.println("\nUsuário adicionado com sucesso.\n");
    }
    private static void adicionarLivro(BibliotecaController controller, Scanner input){
        System.out.println("\n");
        System.out.println("Digite o título do livro: ");
        String titulo = input.nextLine();
        System.out.println("Digite o autor do livro: ");
        String autor = input.nextLine();
        System.out.println("Digite o gênero do livro: ");
        String genero = input.nextLine();
        System.out.println("Digite o ano de publicação: ");
        int anoPublicacao = Integer.parseInt(input.nextLine());
        System.out.println("Digite a quantidade disponível: \n");
        int quantidade = Integer.parseInt(input.nextLine());
        Livro livro = new Livro(titulo, autor, genero, anoPublicacao, quantidade);
        controller.adicionarLivro(livro);
        System.out.println("\nLivro adicionado com sucesso.\n");
    }
    private static void listarLivros(BibliotecaController controller){
        System.out.println("\n");
        List<Livro> livros = controller.listarTodosLivros();
        if (livros.isEmpty()){
            System.out.println("\nNenhum livro cadastrado.\n");
        } 
        else{
            System.out.println("Livro cadastrado: \n");
            for (Livro livro : livros){
                System.out.println(livro.getTitulo() + " por: " + livro.getAutor());
            }
        }
    }    
    private static void listarUsuarios(BibliotecaController controller){
        System.out.println("\n");
        List<Usuario> usuarios = controller.listarTodosUsuarios();
        if (usuarios.isEmpty()){
            System.out.println("\nNenhum usuário cadastrado.\n");
        } 
        else{
            System.out.println("\nUsuário cadastrado:\n");
            for (Usuario usuario : usuarios){
                System.out.println(usuario.getNome() + " - " + usuario.getCpf());
            }
        }
    }    
    private static void realizarEmprestimo(BibliotecaController controller, Scanner input){
        System.out.println("\n");
        System.out.println("Digite o CPF do usuário: ");
        String cpf = input.nextLine();
        System.out.println("Digite o título do livro: ");
        String titulo = input.nextLine();
        Usuario usuario = controller.verificarSituacaoUsuario(cpf);
        if (usuario == null){
            System.out.println("\nUsuário não encontrado.\n");
            return;
        }
        Livro livro = controller.pesquisarLivroPorTitulo(titulo);
        if (livro == null){
            System.out.println("\nLivro não encontrado.\n");
            return;
        }
        try{
            controller.emprestarLivro(usuario, livro);
            System.out.println("\nEmpréstimo realizado com sucesso.\n");
        } 
        catch (LivrosEmprestado | EmprestimosExcedidos e){
            System.out.println(e.getMessage());
        } 
        catch (Exception e){
            System.out.println("\nErro ao realizar empréstimo: " + e.getMessage());
        }
    }
    private static void removerLivro(BibliotecaController controller, Scanner input){
        System.out.println("\n");
        System.out.println("Digite o título do livro que deseja remover: ");
        String titulo = input.nextLine();
        Livro livro = controller.pesquisarLivroPorTitulo(titulo);
        if (livro == null){
            System.out.println("\nLivro não encontrado.\n");
            return;
        }
        controller.removerLivro(livro);
        System.out.println("\nLivro removido com sucesso.\n");
    }
    private static void removerUsuario(BibliotecaController controller, Scanner input){
        System.out.println("\n");
        System.out.println("Digite o CPF do usuário que deseja remover: ");
        String cpf = input.nextLine();
        Usuario usuario = controller.verificarSituacaoUsuario(cpf);
        if (usuario == null){
            System.out.println("\nUsuário não encontrado.\n");
            return;
        }
        controller.removerUsuario(usuario);
        System.out.println("\nUsuário removido com sucesso.\n");
    }
}
