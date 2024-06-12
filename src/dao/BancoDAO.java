package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Bibliotecario;
import model.Emprestimo;
import model.Estudante;
import model.Livro;
import model.Professor;
import model.Usuario;

public class BancoDAO{
    private static BancoDAO instance;
    private final List<Usuario> usuarios;
    private final List<Livro> livros;
    private final List<Emprestimo> emprestimosAtivos;

    private BancoDAO(){
        usuarios = new ArrayList<>();
        livros = new ArrayList<>();
        emprestimosAtivos = new ArrayList<>();

        usuarios.add(new Estudante("Joao", "11111111111", "2022001", LocalDate.of(2004, 1, 15), "Engenharia"));
        usuarios.add(new Estudante("Victor", "22222222222", "2022002", LocalDate.of(2004, 2, 18), "TI"));
        usuarios.add(new Estudante("Tiago", "33333333333", "2022003", LocalDate.of(2003, 6, 7), "C&T"));
        usuarios.add(new Professor("Gustavo", "44444444444", "P2022001", LocalDate.of(1980, 2, 20), "C&T"));
        usuarios.add(new Professor("Danillo", "55555555555", "P2022002", LocalDate.of(1981, 5, 5), "Geografia"));
        usuarios.add(new Bibliotecario("Paulo Cezar", "12345678901", "1234", LocalDate.of(1980, 5, 20), "paulo", "senha123"));

        livros.add(new Livro("Dom Quixote", "Miguel de Cervantes", "Romance de cavalaria", 1605, 5));
        livros.add(new Livro("One Piece", "Eiichiro Oda", "Aventura", 1998, 6));
        livros.add(new Livro("Valhaisen", "Landinus", "Aventura", 2024, 4));
        livros.add(new Livro("Amazing Fantasy #15", "Stan Lee", "Quadrinhos, super-heróis", 1962, 3));
        livros.add(new Livro("Naruto", "Kishimoto", "Ninja", 1999, 8));
    }

    public static synchronized BancoDAO getInstance(){
        if (instance == null){
            instance = new BancoDAO();
        }
        return instance;
    }

    public void adicionarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public void adicionarLivro(Livro livro){
        livros.add(livro);
    }

    public void adicionarEmprestimo(Emprestimo emprestimo){
        emprestimosAtivos.add(emprestimo);
    }

    public List<Usuario> getUsuarios(){
        return usuarios;
    }

    public List<Livro> getLivros(){
        return livros;
    }

    public List<Emprestimo> getEmprestimosAtivos(){
        return emprestimosAtivos;
    }
}
