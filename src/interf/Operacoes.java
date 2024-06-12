package interf;

import java.util.List;
import model.Emprestimo;
import model.Livro;
import model.Usuario;

public interface Operacoes{
    void adicionarLivro(Livro livro);

    void removerLivro(Livro livro);

    Livro pesquisarLivroPorTitulo(String titulo);

    List<Livro> pesquisarLivrosPorAutor(String autor);

    void adicionarUsuario(Usuario usuario);

    void removerUsuario(Usuario usuario);

    Usuario verificarSituacaoUsuario(String cpf);

    List<Emprestimo> listarEmprestimosAtivos(Usuario usuario);

    void adicionarEmprestimo(Emprestimo emprestimo) throws Exception;
}