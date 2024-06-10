package dao;

import java.util.ArrayList;
import java.util.List;
import model.Emprestimo;
import model.Livro;
import model.Usuario;

public class BancoDAO {
    private static BancoDAO instance;
    private final List<Usuario> usuarios;
    private final List<Livro> livros;
    private final List<Emprestimo> emprestimosAtivos;

    private BancoDAO() {
        usuarios = new ArrayList<>();
        livros = new ArrayList<>();
        emprestimosAtivos = new ArrayList<>();
        // Adicionar objetos iniciais para teste
    }

    public static synchronized BancoDAO getInstance() {
        if (instance == null) {
            instance = new BancoDAO();
        }
        return instance;
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimosAtivos.add(emprestimo);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public List<Emprestimo> getEmprestimosAtivos() {
        return emprestimosAtivos;
    }
}
