Apresentação do Codigo

Este sistema de biblioteca é projetado para controlar o empréstimo de livros em instituições acadêmicas. Além de permitir a adição, remoção, devoluçao e pesquisa de livros e usuários, ele também permite que você controle o empréstimo de livros.A seguir estão as classes principais do sistema, bem como suas funcionalidades e como os usuários podem usá-lo.

Classes e Métodos:

1. BibliotecaController
A biblioteca é administrada por esta classe principal. Ela usa o BancoDAO para persistência de dados e utiliza a interface Operações.

Construtor:

- BibliotecaController(): inicia a instância do BancoDAO.

Métodos:

- adicionarLivro(): Adiciona um novo livro ao banco de dados.
- removerLivro(): Remove um livro do banco de dados pelo título.
- pesquisarLivroPorTitulo(): Pesquisa um livro pelo título.
- pesquisarLivrosPorAutor(): Lista todos os livros de um determinado autor.
- adicionarUsuario(): Adiciona um novo usuário ao banco de dados.
- removerUsuario(): Remove um usuário do banco de dados pelo CPF.
- verificarSituacaoUsuario(): Verifica a situação de um usuário pelo CPF.
- listaEmprestimosAtivos(): Lista os empréstimos ativos de um usuário pelo CPF.
- adicionarEmprestimo(): Realiza um novo empréstimo de livro para um usuário.
- emprestarLivro(): Permite que um usuário empreste um livro, verificando disponibilidade e limites.
- devolverLivro(): Realiza a devolução de um livro emprestado por um usuário.
- listaTodosLivros(): Lista todos os livros cadastrados no sistema.
- listaTodosUsuarios(): Lista todos os usuários cadastrados no sistema.
- setBibliotecario(): Define o bibliotecário responsável pelo sistema.
- getBibliotecario(): Retorna o bibliotecário responsável atualmente configurado.

2. BancoDAO
A classe BancoDAO é responsável por armazenar e gerenciar os dados da biblioteca, incluindo usuários, livros e informações de empréstimos. Ela utiliza persistência de dados para manter a integridade das informações entre as execuções do programa.

3. Exceções
Classes destinadas a abordar situações particulares de erro:

- LivroEmprestado: é lançado quando um livro está sendo emprestado .
- EmprestimosExcedidos: é lançada quando um usuário excede o limite de empréstimos.

4. Interface Operacoes
Define os métodos que devem ser implementados pelo BibliotecaController.

5. Modelos de Dados
Classes que representam os principais dados do sistema:

- Bibliotecario: Representa um bibliotecário.
- Emprestimo: Representa um empréstimo de livro.
- Estudante: Representa um estudante.
- Livro: Representa um livro.
- Professor: Representa um professor.
- Usuario: Classe abstrata que representa um usuário da biblioteca.

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
devolverLivro(BibliotecaController controller): Devolve o livro do usuario para a biblioteca.
listarUsuarios(BibliotecaController controller): Lista todos os usuários.
realizarEmprestimo(BibliotecaController controller, Scanner input): Realiza um empréstimo de livro.
removerLivro(BibliotecaController controller, Scanner input): Remove um livro pelo título.
removerUsuario(BibliotecaController controller, Scanner input): Remove um usuário pelo CPF.

------------------------------------------------------------------------------------------------------------------------------------------

Manual do Usuário

Para utilizar o sistema:

1 - Login do Bibliotecário:

Ao iniciar o programa, será solicitado que você insira o login e senha do bibliotecário. Utilize as credenciais pré-definidas:
- Login: paulo
- Senha: senha123

2 - Menu de Comandos:

Após o login bem-sucedido, você será apresentado ao menu de comandos.
Para ver todas as opções, digite 'help'. Digite o comando desejado conforme as opções disponíveis.

3 - Operações Disponíveis:

Use os comandos para adicionar usuários '(adicionar usuario)', adicionar livros '(adicionar livro)', listar livros '(listar livros)', listar usuários '(listar usuarios)', realizar empréstimos '(realizar emprestimo)', devolver livros ('devolver livro)', remover livros '(remover livro)' e remover usuários '(remover usuario)'.

4 - Encerrando o Programa:

Para sair do programa, digite 'exit' no menu de comandos.
