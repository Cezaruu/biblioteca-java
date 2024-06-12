package controller;

import dao.BancoDAO;
import exception.EmprestimosExcedidos;
import exception.LivrosEmprestado;
import interf.Operacoes;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Bibliotecario;
import model.Emprestimo;
import model.Estudante;
import model.Livro;
import model.Professor;
import model.Usuario;

public class BibliotecaController implements Operacoes{
    public final BancoDAO bancoDAO;
    private Bibliotecario bibliotecario;
    public BibliotecaController(){
        this.bancoDAO = BancoDAO.getInstance();
    }
    @Override
    public void adicionarLivro(Livro livro){
        bancoDAO.adicionarLivro(livro);
    }
    @Override
    public void removerLivro(Livro livro){
        bancoDAO.getLivros().remove(livro);
    }
    @Override
    public Livro pesquisarLivroPorTitulo(String titulo){
        for (Livro livro : bancoDAO.getLivros()) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)){
                return livro;
            }
        }
        return null;
    }
    @Override
    public List<Livro> pesquisarLivrosPorAutor(String autor){
        List<Livro> livrosPorAutor = new ArrayList<>();
        for (Livro livro : bancoDAO.getLivros()) {
            if (livro.getAutor().equalsIgnoreCase(autor)){
                livrosPorAutor.add(livro);
            }
        }
        return livrosPorAutor;
    }
    @Override
    public void adicionarUsuario(Usuario usuario){
        bancoDAO.adicionarUsuario(usuario);
    }
    @Override
    public void removerUsuario(Usuario usuario){
        bancoDAO.getUsuarios().remove(usuario);
    }
    @Override
    public Usuario verificarSituacaoUsuario(String cpf){
        for (Usuario usuario : bancoDAO.getUsuarios()){
            if (usuario.getCpf().equals(cpf)){
                return usuario;
            }
        }
        return null;
    }  
    @Override
    public List<Emprestimo> listarEmprestimosAtivos(Usuario usuario){
        List<Emprestimo> emprestimosDoUsuario = new ArrayList<>();
        for (Emprestimo emprestimo : bancoDAO.getEmprestimosAtivos()){
            if (emprestimo.getUsuario().equals(usuario)){
                emprestimosDoUsuario.add(emprestimo);
            }
        }
        return emprestimosDoUsuario;
    }
    @Override
    public void adicionarEmprestimo(Emprestimo emprestimo) throws Exception{
        for (Emprestimo e : bancoDAO.getEmprestimosAtivos()){
            if (e.getLivro().equals(emprestimo.getLivro())){
                throw new LivrosEmprestado("O livro já está emprestado.");
            }
        }
        Livro livro = emprestimo.getLivro();
        if (livro.getQtdEstoque() <= 0){
            throw new Exception("Não há exemplares disponíveis para empréstimo.");
        }
        livro.setQtdEstoque(livro.getQtdEstoque() - 1);
        bancoDAO.adicionarEmprestimo(emprestimo);
    }    
    public void emprestarLivro(Usuario usuario, Livro livro) throws Exception{
        List<Emprestimo> emprestimosAtivos = listarEmprestimosAtivos(usuario);
        int maxLivros;
        int diasEmprestimo;

        if (usuario instanceof Estudante){
            maxLivros = 3;
            diasEmprestimo = 15;
        } 
        else if (usuario instanceof Professor || usuario instanceof Bibliotecario){
            maxLivros = 5;
            diasEmprestimo = 30;
        } 
        else{
            throw new Exception("Tipo de usuário não permitido para empréstimo.");
        }

        if (emprestimosAtivos.size() >= maxLivros){
            throw new EmprestimosExcedidos("Usuário atingiu o limite de livros emprestados.");
        }
        Emprestimo emprestimo = new Emprestimo(usuario, livro, LocalDate.now(), LocalDate.now().plusDays(diasEmprestimo));
        adicionarEmprestimo(emprestimo);
    }
    public List<Livro> listarTodosLivros(){
        return bancoDAO.getLivros();
    }
    public List<Usuario> listarTodosUsuarios(){
        return bancoDAO.getUsuarios();
    }    
    public void setBibliotecario(Bibliotecario bibliotecario){
        this.bibliotecario = bibliotecario;
    }
    public Bibliotecario getBibliotecario(){
        return bibliotecario;
    }
}
