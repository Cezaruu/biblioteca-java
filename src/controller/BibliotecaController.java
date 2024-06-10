package controller;

import dao.BancoDAO;
import exception.LivroJaEmprestadoException;
import interf.Operacoes;
import java.util.ArrayList;
import java.util.List;
import model.Emprestimo;
import model.Livro;
import model.Usuario;

public class BibliotecaController implements Operacoes {
    public final BancoDAO bancoDAO;

    public BibliotecaController() {
        this.bancoDAO = BancoDAO.getInstance();
    }

    @Override
    public void adicionarLivro(Livro livro) {
        bancoDAO.adicionarLivro(livro);
    }

    @Override
    public void removerLivro(Livro livro) {
        bancoDAO.getLivros().remove(livro);
    }

    @Override
    public Livro pesquisarLivroPorTitulo(String titulo) {
        for (Livro livro : bancoDAO.getLivros()) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    @Override
    public List<Livro> pesquisarLivrosPorAutor(String autor) {
        List<Livro> livrosPorAutor = new ArrayList<>();
        for (Livro livro : bancoDAO.getLivros()) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                livrosPorAutor.add(livro);
            }
        }
        return livrosPorAutor;
    }

    @Override
    public void adicionarUsuario(Usuario usuario) {
        bancoDAO.adicionarUsuario(usuario);
    }

    @Override
    public void removerUsuario(Usuario usuario) {
        bancoDAO.getUsuarios().remove(usuario);
    }

    @Override
    public Usuario verificarSituacaoUsuario(String cpf) {
        for (Usuario usuario : bancoDAO.getUsuarios()) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public List<Emprestimo> listarEmprestimosAtivos(Usuario usuario) {
        List<Emprestimo> emprestimosDoUsuario = new ArrayList<>();
        for (Emprestimo emprestimo : bancoDAO.getEmprestimosAtivos()) {
            if (emprestimo.getUsuario().equals(usuario)) {
                emprestimosDoUsuario.add(emprestimo);
            }
        }
        return emprestimosDoUsuario;
    }

    @Override
    public void adicionarEmprestimo(Emprestimo emprestimo) throws Exception {
        // Verificar se o livro já está emprestado
        for (Emprestimo e : bancoDAO.getEmprestimosAtivos()) {
            if (e.getLivro().equals(emprestimo.getLivro())) {
                throw new LivroJaEmprestadoException("O livro já está emprestado.");
            }
        }
        bancoDAO.adicionarEmprestimo(emprestimo);
    }
}
