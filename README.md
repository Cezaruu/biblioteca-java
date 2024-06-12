Apresentação

Este sistema de biblioteca é projetado para controlar o empréstimo de livros em instituições acadêmicas.
Além de permitir a adição, remoção e pesquisa de livros e usuários, ele também permite que você controle o empréstimo de livros.
A seguir estão as classes principais do sistema, bem como suas funcionalidades e como os usuários podem usá-lo.

Classes e Métodos:

1. BibliotecaController
A biblioteca é administrada por esta classe principal. Ela usa o BancoDAO para persistência de dados e utiliza a interface Operações.

2. BancoDAO
Classe responsável por armazenar e gerenciar os dados da biblioteca (usuários, livros e empréstimos).

Construtor:

BibliotecaController(): inicia a instância do BancoDAO.

Métodos:

adicionarLivro:Adiciona um livro ao banco de dados.
removerLivro: Exclui um livro do banco de dados.
PesquisarLivroPorTitulo: Use o título para pesquisar um livro.
PesquisarLivrosPorAutor: Pesquisa livros usando o nome do autor.
AdicionarUsuario: adiciona um usuário ao banco de dados.
removerUsuario: Remove um usuário do banco de dados.
verificarSituacaoUsuario: Use o CPF para verificar a situação de um usuário.
listaEmprestimosAtivos: mostra os empréstimos ativos de um usuário.
AdicionarEmprestimo: inclui um empréstimo no banco de dados.
EmprestarLivro: Permite que um usuário pegue emprestado um livro depois de verificar seus limites e disponibilidade.
listaTodosLivros(): apresenta uma lista de todos os livros cadastrados.
listaTodosUsuarios(): apresenta uma lista de todos os usuários cadastrados.
setBibliotecario(Bibliotecario bibliotecario): estabelece quem é responsável pelo departamento da biblioteca.
getBibliotecario(): Retorna o bibliotecário responsavel.

3. Exceções
Classes destinadas a abordar situações particulares de erro:

LivroEmprestado: é lançado quando um livro está sendo emprestado .
EmprestimosExcedidos: é lançada quando um usuário excede o limite de empréstimos.

4. Interface Operacoes
Define os métodos que devem ser implementados pelo BibliotecaController.

5. Modelos de Dados
Classes que representam os principais dados do sistema:

Bibliotecario: Representa um bibliotecário.
Emprestimo: Representa um empréstimo de livro.
Estudante: Representa um estudante.
Livro: Representa um livro.
Professor: Representa um professor.
Usuario: Classe abstrata que representa um usuário da biblioteca.

6. Persistência
Classe Persistencia responsável por salvar e carregar objetos em arquivos Binários.

7. Classe Principal (Main)
A classe principal contém o método main e métodos auxiliares para interagir com o usuário via console.

Métodos:
main(String[] args): Inicializa o sistema e realiza operações de teste.
signIn(Bibliotecario bibliotecario, BibliotecaController controller): Realiza o login do bibliotecário.
realizarOperacoes(BibliotecaController controller, Scanner input): Permite ao usuário realizar operações na biblioteca.
mostrarOpcoes(): Mostra as opções de comandos disponíveis.
adicionarUsuario(BibliotecaController controller, Scanner input): Adiciona um novo usuário.
adicionarLivro(BibliotecaController controller, Scanner input): Adiciona um novo livro.
listarLivros(BibliotecaController controller): Lista todos os livros.
listarUsuarios(BibliotecaController controller): Lista todos os usuários.
realizarEmprestimo(BibliotecaController controller, Scanner input): Realiza um empréstimo de livro.
removerLivro(BibliotecaController controller, Scanner input): Remove um livro pelo título.
removerUsuario(BibliotecaController controller, Scanner input): Remove um usuário pelo CPF.
