import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 *
 * @author gabrielle.ddutra
 */
public class appData {
    Connection conectar;
    PreparedStatement st;
    ResultSet resultado;

    // Tratamento de Exceção: o método declara que pode lançar exceções do tipo
    // ClassNotFoundException e SQLException
    private void conectar() throws ClassNotFoundException, SQLException {
        // conexão com o banco de dados
        Class.forName("com.mysql.cj.jdbc.Driver");
        conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema_pi", "root", "P@$$w0rd");

    }

    // Método estático, não relacionado a instância da classe appData
    public static boolean validarCPF(String cpf) {
        // Remover caracteres não numéricos
        cpf = cpf.replaceAll("[^\\d]", "");

        // Verificar se o CPF tem 11 dígitos ou se todos os dígitos são iguais
        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Calcular o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int resto = soma % 11;
        int primeiroDigito = (resto < 2) ? 0 : 11 - resto;

        // Calcular o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        soma += primeiroDigito * 2;
        resto = soma % 11;
        int segundoDigito = (resto < 2) ? 0 : 11 - resto;

        return (primeiroDigito == Character.getNumericValue(cpf.charAt(9)) &&
                segundoDigito == Character.getNumericValue(cpf.charAt(10)));
    }

    public void cadastrarUsuario(String c, String u, String s) throws ClassNotFoundException, SQLException {
        boolean dadosValidos = false;

        while (!dadosValidos) {
            try {
                // Verificar se o CPF é válido
                if (!validarCPF(c)) {
                    throw new IllegalArgumentException("CPF inválido.");
                }

                // Verificar se o email é válido
                if (!validarEmail(u)) {
                    throw new IllegalArgumentException("Email inválido.");
                }

                // Conectar ao banco de dados
                conectar();

                // Preparar a instrução SQL para inserir o usuário
                st = conectar.prepareStatement("INSERT INTO usuarios(cpf, email, senha) VALUES(?, ?, ?)");

                // Configurar os parâmetros da consulta SQL
                st.setString(1, c); // CPF
                st.setString(2, u); // Email
                st.setString(3, s); // Senha

                // Executar a inserção no banco de dados
                st.executeUpdate();
                dadosValidos = true; // Dados válidos, sair do loop
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                // Solicitar novamente os dados inválidos
                if (e.getMessage().contains("CPF")) {
                    c = JOptionPane.showInputDialog("Digite um CPF válido:");
                } else if (e.getMessage().contains("Email")) {
                    u = JOptionPane.showInputDialog("Digite um email válido:");
                }
            } catch (SQLException e) {
                // Tratar erros de SQL, caso ocorram
                if (e.getMessage().contains("Duplicate entry")) {
                    JOptionPane.showMessageDialog(null, "Usuário já cadastrado.");
                    return; // Sair do método se o usuário já estiver cadastrado
                } else {
                    JOptionPane.showMessageDialog(null, "Erro na conexão com o banco de dados: " + e.getMessage());
                    return; // Sair do método em caso de erro de conexão
                }
            } catch (Exception e) {
                // Tratar outros tipos de erros
                JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
                return; // Sair do método em caso de erro inesperado
            } finally {
                // Fechar a conexão e outros recursos
                if (st != null)
                    st.close();
                if (conectar != null)
                    conectar.close();
            }
        }
    }

    private boolean validarEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    public ResultSet entrar(String u, String s) throws ClassNotFoundException, SQLException {
        conectar();
        // 1 ENTRAR
        st = conectar.prepareStatement("SELECT * FROM usuarios WHERE email = ? AND senha = ?");
        st.setString(1, u);
        st.setString(2, s);
        resultado = st.executeQuery();
        return resultado;
    }

    public void submeterFilme(String t, String d, String dur, String g, String s, String dt, String c)
            throws ClassNotFoundException, SQLException {
        conectar();
        // 3 SUBMETER FILME
        st = conectar.prepareStatement(
                "INSERT INTO filmes(titulo, diretor, duracao, genero, sinopse, data_lancamento, classificacao_indicativa) VALUES(?,?,?,?,?,?,?)");
        st.setString(1, t);
        st.setString(2, d);
        st.setString(3, dur);
        st.setString(4, g);
        st.setString(5, s);
        st.setString(6, dt);
        st.setString(7, c);
        st.executeUpdate();
    }

    // Método para listar os filmes submetidos e avaliados com base no gênero
    // fornecido
    public ResultSet listarFilmes(String genero) throws ClassNotFoundException, SQLException {
        conectar();
        if (genero.equals("Todos")) {
            st = conectar.prepareStatement("SELECT f.*, fa.cinematografia, fa.originalidade, fa.comentario_tecnico "
                    + "FROM filmes f LEFT JOIN filmes_avaliacao fa ON f.id_filme = fa.fk_id_filme");
        } else {
            st = conectar.prepareStatement("SELECT f.*, fa.cinematografia, fa.originalidade, fa.comentario_tecnico "
                    + "FROM filmes f LEFT JOIN filmes_avaliacao fa ON f.id_filme = fa.fk_id_filme "
                    + "WHERE f.genero = ?");
            st.setString(1, genero);
        }
        return st.executeQuery();
    }

    // Método para buscar os detalhes de um filme com base no ID fornecido
    public ResultSet avaliarFilme(int id) throws ClassNotFoundException, SQLException {
        conectar();
        // Consulta para selecionar o filme com base no ID
        st = conectar.prepareStatement("SELECT * FROM filmes WHERE id_filme = ?");
        st.setInt(1, id);
        return st.executeQuery();
    }

    // Método para submeter a avaliação de um filme
    public void submeterAvaliacao(int id, String c, String o, String ct) throws ClassNotFoundException, SQLException {
        conectar();
        // Inserção dos dados da avaliação no banco de dados
        st = conectar.prepareStatement(
                "INSERT INTO filmes_avaliacao(fk_id_filme, cinematografia, originalidade, comentario_tecnico) VALUES(?,?,?,?)");
        st.setInt(1, id);
        st.setString(2, c);
        st.setString(3, o);
        st.setString(4, ct);
        st.executeUpdate();
    }

    // Método para submeter Programação
    public void submeterProgramacao(String t, String d, String dt, String h, String l)
            throws ClassNotFoundException, SQLException {
        conectar();
        // Inserção dos dados da programação no banco de dados
        st = conectar.prepareStatement(
                "INSERT INTO programacao(fk_titulo, fk_diretor, data, horario, local) VALUES(?,?,?,?,?)");
        st.setString(1, t);
        st.setString(2, d);
        st.setString(3, dt);
        st.setString(4, h);
        st.setString(5, l);
        st.executeUpdate();
    }

    // Método para listar Programação
    public ResultSet listarProgramacao() throws ClassNotFoundException, SQLException {
        conectar();
        // Consulta para selecionar a programação
        st = conectar.prepareStatement("SELECT * FROM programacao");
        return st.executeQuery();
    }

    // Método para buscar os detalhes de um filme com base no ID fornecido
    public ResultSet buscarFilme(int id) throws ClassNotFoundException, SQLException {
        conectar();
        // Consulta para selecionar o filme com base no ID
        st = conectar.prepareStatement("SELECT * FROM filmes WHERE id_filme = ?");
        st.setInt(1, id);
        return st.executeQuery();
    }

    // Método para editar Submissão de Filme
    public void editarFilme(int id, String t, String d, String dur, String g, String s, String dt, String c)
            throws ClassNotFoundException, SQLException {
        conectar();
        // Atualização dos dados do filme no banco de dados
        st = conectar.prepareStatement(
                "UPDATE filmes SET titulo = ?, diretor = ?, duracao = ?, genero = ?, sinopse = ?, data_lancamento = ?, classificacao_indicativa = ? WHERE id_filme = ?");
        st.setString(1, t);
        st.setString(2, d);
        st.setString(3, dur);
        st.setString(4, g);
        st.setString(5, s);
        st.setString(6, dt);
        st.setString(7, c);
        st.setInt(8, id);
        st.executeUpdate();

    }

    // Método para excluir Submissão de Filme
    public void excluirSubmissao(int id) throws ClassNotFoundException, SQLException {
        conectar();
        // Exclusão do filme no banco de dados
        st = conectar.prepareStatement("DELETE FROM filmes WHERE id_filme = ?");
        st.setInt(1, id);
        st.executeUpdate();
    }

    // Método para editar Avaliação de Filme
    public void editarAvali(int id, String titulo, String diretor, String genero, String duracao, String data,
            String classificacao, String cinematografia, String originalidade, String comentario)
            throws ClassNotFoundException, SQLException {
        conectar();

        // Atualização dos dados da avaliação no banco de dados
        st = conectar.prepareStatement(
                "UPDATE filmes_avaliacao SET cinematografia = ?, originalidade = ?, comentario_tecnico = ? WHERE id_avaliacao = ?");
        st.setString(1, cinematografia);
        st.setString(2, originalidade);
        st.setString(3, comentario);
        st.setInt(4, id);
        st.executeUpdate();
    }

    // Método para buscar filme avaliado
    public ResultSet buscarAvaliacao(int id) throws ClassNotFoundException, SQLException {
        conectar();
        // Consulta para selecionar a avaliação do filme com base no ID
        st = conectar.prepareStatement(
                "SELECT f.*, a.cinematografia, a.originalidade, a.comentario_tecnico FROM filmes f INNER JOIN filmes_avaliacao a ON f.id_filme = a.fk_id_filme WHERE a.id_avaliacao = ?");
        st.setInt(1, id);
        return st.executeQuery();
    }

    public void excluirAvaliacao(int id) throws ClassNotFoundException, SQLException {
        conectar();
        // Exclusão da avaliação do filme no banco de dados
        st = conectar.prepareStatement("DELETE FROM filmes_avaliacao WHERE id_avaliacao = ?");
        st.setInt(1, id);
        st.executeUpdate();

    }

    // Método para buscar filme pelo ID
    public ResultSet buscarFilmePorId(int id) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectar.prepareStatement("SELECT titulo, diretor FROM filmes WHERE id_filme = ?");
        st.setInt(1, id);
        return st.executeQuery();
    }

    // Método para criar Programação
    public void criarProgramacao(int idFilme, String titulo, String diretor, String data, String horario, String local)
            throws ClassNotFoundException, SQLException {
        conectar();
        st = conectar.prepareStatement(
                "INSERT INTO programacao(fk_id_filme, fk_titulo, fk_diretor, data, horario, local) VALUES(?,?,?,?,?,?)");
        st.setInt(1, idFilme);
        st.setString(2, titulo);
        st.setString(3, diretor);
        st.setString(4, data);
        st.setString(5, horario);
        st.setString(6, local);
        st.executeUpdate();
    }

    // Método para buscar Programação
    public ResultSet buscarProgramacoes() throws ClassNotFoundException, SQLException {
        conectar();
        st = conectar.prepareStatement(
                "SELECT p.id_programa, f.id_filme, p.fk_titulo AS titulo, p.fk_diretor AS diretor, p.data, p.horario, p.local FROM programacao p INNER JOIN filmes f ON p.fk_id_filme = f.id_filme");
        return st.executeQuery();
    }

    // Método para buscar Programação dentro da Edição
    public ResultSet buscarProgramacoesEditar(int idPrograma) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectar.prepareStatement(
                "SELECT fk_titulo, fk_diretor, data, horario, local FROM programacao WHERE id_programa = ?");
        st.setInt(1, idPrograma);
        return st.executeQuery();
    }

    // Método para editar Programação
    public void editarProgramacao(int idPrograma, String data, String horario, String local)
            throws ClassNotFoundException, SQLException {
        conectar();
        st = conectar.prepareStatement("UPDATE programacao SET data = ?, horario = ?, local = ? WHERE id_programa = ?");
        st.setString(1, data);
        st.setString(2, horario);
        st.setString(3, local);
        st.setInt(4, idPrograma);
        st.executeUpdate();
    }

    // Método para excluir Programação
    public void excluirProgramacao(int idPrograma) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectar.prepareStatement("DELETE FROM programacao WHERE id_programa = ?");
        st.setInt(1, idPrograma);
        st.executeUpdate();
    }

    // Método para criar Evento
    public void criarEvento(String nome, String data, String hora, String local, String descricao)
            throws ClassNotFoundException, SQLException {
        conectar();
        st = conectar.prepareStatement("INSERT INTO eventos(nome, data, hora, local, descricao) VALUES(?,?,?,?,?)");
        st.setString(1, nome);
        st.setString(2, data);
        st.setString(3, hora);
        st.setString(4, local);
        st.setString(5, descricao);
        st.executeUpdate();
    }

    // Método para buscar Eventos
    public ResultSet buscarEventos() throws ClassNotFoundException, SQLException {
        conectar();
        st = conectar.prepareStatement("SELECT * FROM eventos");
        return st.executeQuery();
    }

    // Método para buscar Eventos dentro da Edição
    public ResultSet buscarEventosEditar(int idEvento) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectar.prepareStatement("SELECT * FROM eventos WHERE id_evento = ?");
        st.setInt(1, idEvento);
        return st.executeQuery();
    }

    // Método para editar Evento
    public void editarEvento(int idEvento, String nome, String data, String hora, String local, String descricao)
            throws ClassNotFoundException, SQLException {
        conectar();
        st = conectar.prepareStatement(
                "UPDATE eventos SET nome = ?, data = ?, hora = ?, local = ?, descricao = ? WHERE id_evento = ?");
        st.setString(1, nome);
        st.setString(2, data);
        st.setString(3, hora);
        st.setString(4, local);
        st.setString(5, descricao);
        st.setInt(6, idEvento);
        st.executeUpdate();
    }

    // Método para excluir Evento
    public void excluirEvento(int idEvento) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectar.prepareStatement("DELETE FROM eventos WHERE id_evento = ?");
        st.setInt(1, idEvento);
        st.executeUpdate();
    }

    public ResultSet getFilmeId(String titulo) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectar.prepareStatement("SELECT id_filme FROM filmes WHERE titulo = ?");
        st.setString(1, titulo);
        return st.executeQuery();
    }

    public ResultSet getFilmeDetalhes(int idFilme) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectar.prepareStatement(
                "SELECT fk_titulo, fk_diretor, data, horario, local FROM programacao WHERE fk_id_filme = ?");
        st.setInt(1, idFilme);
        return st.executeQuery();
    }

    public ResultSet isProgramacaoValida(String data, String horario, String local)
            throws ClassNotFoundException, SQLException {
        conectar();
        st = conectar.prepareStatement("SELECT * FROM programacao WHERE data = ? AND horario = ? AND local = ?");
        st.setString(1, data);
        st.setString(2, horario);
        st.setString(3, local);
        return st.executeQuery();
    }

    public void criarIngresso(int idFilme, String data, String horario, String local, int vagas)
            throws ClassNotFoundException, SQLException {
        conectar();
        st = conectar.prepareStatement(
                "INSERT INTO ingressos(fk_id_filme, fk_data, fk_horario, fk_local, vagas) VALUES (?, ?, ?, ?, ?)");
        st.setInt(1, idFilme);
        st.setString(2, data);
        st.setString(3, horario);
        st.setString(4, local);
        st.setInt(5, vagas);
        st.executeUpdate();
    }

    public ResultSet listarIngressos() throws ClassNotFoundException, SQLException {
        conectar();
        st = conectar.prepareStatement(
                "SELECT i.id_ingresso, f.titulo, f.diretor, i.fk_data, i.fk_horario, i.fk_local, i.vagas " +
                        "FROM ingressos i " +
                        "INNER JOIN filmes f ON i.fk_id_filme = f.id_filme");
        return st.executeQuery();
    }

    public ResultSet buscarIngresso(int idIngresso) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectar.prepareStatement(
                "SELECT i.id_ingresso, f.titulo, f.diretor, i.fk_data, i.fk_horario, i.fk_local, i.vagas " +
                        "FROM ingressos i " +
                        "INNER JOIN filmes f ON i.fk_id_filme = f.id_filme " +
                        "WHERE i.id_ingresso = ?");
        st.setInt(1, idIngresso);
        return st.executeQuery();
    }

    public void editarIngresso(int idIngresso, String titulo, String diretor, String data, String horario, String local,
            int vagas) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectar.prepareStatement(
                "UPDATE ingressos i " +
                        "JOIN filmes f ON i.fk_id_filme = f.id_filme " +
                        "SET f.titulo = ?, f.diretor = ?, i.fk_data = ?, i.fk_horario = ?, i.fk_local = ?, i.vagas = ? "
                        +
                        "WHERE i.id_ingresso = ?");
        st.setString(1, titulo);
        st.setString(2, diretor);
        st.setString(3, data);
        st.setString(4, horario);
        st.setString(5, local);
        st.setInt(6, vagas);
        st.setInt(7, idIngresso);
        st.executeUpdate();
    }

    public void excluirIngresso(int idIngresso) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectar.prepareStatement("DELETE FROM ingressos WHERE id_ingresso = ?");
        st.setInt(1, idIngresso);
        st.executeUpdate();
    }
}