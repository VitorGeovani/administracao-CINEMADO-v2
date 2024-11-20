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

    public boolean submeterFilme(String t, String d, String dur, String g, String s, String dt, String c)
            throws SQLException {
        // Validar que a duração contém apenas números
        if (!dur.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "A duração deve conter apenas números.");
            return false;
        }

        // Validar que a data de lançamento contém apenas números no formato dd/mm/aaaa
        if (!dt.matches("\\d{2}/\\d{2}/\\d{4}")) {
            JOptionPane.showMessageDialog(null, "A data de lançamento deve estar no formato dd/mm/aaaa.");
            return false;
        }

        PreparedStatement st = null;
        Connection conectar = null;

        try {
            // Conectar ao banco de dados
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema_pi", "root", "P@$$w0rd");

            // Submeter filme ao banco de dados
            st = conectar.prepareStatement(
                    "INSERT INTO filmes(titulo, diretor, duracao, genero, sinopse, data_lancamento, classificacao_indicativa) VALUES(?,?,?,?,?,?,?)");
            st.setString(1, t);
            st.setString(2, d);
            st.setString(3, dur);
            st.setString(4, g);
            st.setString(5, s);
            st.setString(6, dt);
            st.setString(7, c);

            // Executa o comando e verifica se foi bem-sucedido
            int rowsInserted = st.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a operação no banco de dados: " + e.getMessage());
            throw e;
        } finally {
            // Liberar recursos
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao fechar o PreparedStatement: " + e.getMessage());
                }
            }
            if (conectar != null) {
                try {
                    conectar.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão: " + e.getMessage());
                }
            }
        }
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
        // Validação para Cinematografia
        if (!c.matches("[0-9,\\.]+")) {
            JOptionPane.showMessageDialog(null, "Erro: Cinematografia deve conter apenas números, '.' ou ','!", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return; // Interrompe o processo em caso de erro
        }

        // Validação para Originalidade
        if (!o.matches("[0-9,\\.]+")) {
            JOptionPane.showMessageDialog(null, "Erro: Originalidade deve conter apenas números, '.' ou ','!", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return; // Interrompe o processo em caso de erro
        }

        // Se as validações passarem, tenta conectar e inserir os dados
        try {
            conectar();
            // Inserção dos dados da avaliação no banco de dados
            st = conectar.prepareStatement(
                    "INSERT INTO filmes_avaliacao(fk_id_filme, cinematografia, originalidade, comentario_tecnico) VALUES(?,?,?,?)");
            st.setInt(1, id);
            st.setString(2, c);
            st.setString(3, o);
            st.setString(4, ct);
            st.executeUpdate();

            // Mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Avaliação submetida com sucesso!", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao submeter a avaliação: " + e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
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
    public boolean editarFilme(int id, String t, String d, String dur, String g, String s, String dt, String c)
            throws SQLException {

        // Validar que a duração contém apenas números
        if (!dur.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "A duração deve conter apenas números.");
            return false;
        }

        // Validar que a data de lançamento contém apenas números no formato dd/mm/aaaa
        if (!dt.matches("\\d{2}/\\d{2}/\\d{4}")) {
            JOptionPane.showMessageDialog(null, "A data de lançamento deve estar no formato dd/mm/aaaa.");
            return false;
        }

        PreparedStatement st = null;
        Connection conectar = null;

        try {
            // Conectar ao banco de dados
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema_pi", "root", "P@$$w0rd");

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

            // Executa a atualização e verifica o sucesso
            int rowsUpdated = st.executeUpdate();
            return rowsUpdated > 0; // Se mais de 0 linhas foram atualizadas, retorna true, caso contrário false

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados: " + e.getMessage());
            throw e; // Propaga a exceção para o método chamador
        } finally {
            // Liberar recursos
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao fechar o PreparedStatement: " + e.getMessage());
                }
            }
            if (conectar != null) {
                try {
                    conectar.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão: " + e.getMessage());
                }
            }
        }
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
    public boolean editarAvali(int id, String titulo, String diretor, String genero, String duracao, String data,
            String classificacao, String cinematografia, String originalidade, String comentario)
            throws ClassNotFoundException, SQLException {

        // Validação para Cinematografia e Originalidade (apenas números com "." ou ",")
        if (!validarEntradaNumerica(cinematografia) || !validarEntradaNumerica(originalidade)) {
            JOptionPane.showMessageDialog(null,
                    "Erro: A Cinematografia e Originalidade devem conter apenas números com '.' ou ','!",
                    "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return false; // Retorna false se a validação falhar
        }

        try {
            conectar();

            // Atualização dos dados da avaliação no banco de dados
            st = conectar.prepareStatement(
                    "UPDATE filmes_avaliacao SET cinematografia = ?, originalidade = ?, comentario_tecnico = ? WHERE id_avaliacao = ?");
            st.setString(1, cinematografia);
            st.setString(2, originalidade);
            st.setString(3, comentario);
            st.setInt(4, id);

            // Executando a atualização
            int linhasAfetadas = st.executeUpdate();

            // Verificando o resultado da operação
            if (linhasAfetadas > 0) {
                // Se a edição for bem-sucedida, retorna true
                return true;
            } else {
                // Caso contrário, exibe uma mensagem e retorna false
                JOptionPane.showMessageDialog(null,
                        "Erro: Nenhuma avaliação encontrada com o ID fornecido.",
                        "Erro de Atualização", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao editar avaliação: " + e.getMessage(),
                    "Erro de Banco de Dados", JOptionPane.ERROR_MESSAGE);
            return false; // Em caso de erro, retorna false
        } finally {
            desconectar();
        }
    }

    // Método para validar se a entrada contém apenas números e vírgula ou ponto
    private boolean validarEntradaNumerica(String valor) {
        // Expressão regular para verificar se o valor contém apenas números com vírgula
        // ou ponto
        return valor.matches("[0-9]+([,.][0-9]+)?");
    }

    private void desconectar() {
        // Fechar a conexão com o banco de dados
        try {
            if (st != null)
                st.close();
            if (conectar != null)
                conectar.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    // Método para criar Programação
    public void criarProgramacao(int idFilme, String titulo, String diretor, String data, String horario, String local)
            throws ClassNotFoundException, SQLException {

        // Validação de Data (formato dd/mm/aaaa ou dd-mm-aaaa)
        if (!validarData(data)) {
            JOptionPane.showMessageDialog(null, "Erro: Data inválida! Use o formato dd/mm/aaaa ou dd-mm-aaaa.",
                    "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return; // Interrompe a execução se a validação falhar
        }

        // Validação de Hora (formato hh:mm)
        if (!validarHora(horario)) {
            JOptionPane.showMessageDialog(null, "Erro: Hora inválida! Use o formato hh:mm.", "Erro de Validação",
                    JOptionPane.ERROR_MESSAGE);
            return; // Interrompe a execução se a validação falhar
        }

        try {
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
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar programação: " + e.getMessage(),
                    "Erro de Banco de Dados", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Validação de Data (dd/mm/aaaa ou dd-mm-aaaa)
    private boolean validarData(String data) {
        // Expressão regular para verificar o formato da data
        String regexData = "^(0[1-9]|[12][0-9]|3[01])[-/]((0[1-9])|(1[0-2]))[-/][0-9]{4}$";
        return data.matches(regexData);
    }

    // Validação de Hora (hh:mm)
    private boolean validarHora(String hora) {
        // Expressão regular para verificar o formato da hora
        String regexHora = "^([01]?[0-9]|2[0-3]):([0-5][0-9])$";
        return hora.matches(regexHora);
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
        conectar(); // Certifique-se de que a conexão está sendo estabelecida corretamente
        st = conectar.prepareStatement(
                "SELECT fk_titulo, fk_diretor, data, horario, local FROM programacao WHERE id_programa = ?");
        st.setInt(1, idPrograma); // Verifique se o idProgramacao está correto
        return st.executeQuery(); // Retorna o ResultSet com os dados encontrados
    }

    // Método para editar Programação
    public void editarProgramacao(int idPrograma, String data, String horario, String local)
            throws ClassNotFoundException, SQLException {
        // Validação de Data (formato dd/mm/aaaa ou dd-mm-aaaa)
        if (!validarData(data)) {
            JOptionPane.showMessageDialog(null, "Erro: Data inválida! Use o formato dd/mm/aaaa ou dd-mm-aaaa.",
                    "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return; // Interrompe a execução se a validação falhar
        }

        // Validação de Hora (formato hh:mm)
        if (!validarHora(horario)) {
            JOptionPane.showMessageDialog(null, "Erro: Hora inválida! Use o formato hh:mm.", "Erro de Validação",
                    JOptionPane.ERROR_MESSAGE);
            return; // Interrompe a execução se a validação falhar
        }

        // Caso as validações passem, prossegue com a edição da programação
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
    // Método para criar Evento com validações de Data e Hora
    public void criarEvento(String nome, String data, String hora, String local, String descricao)
            throws ClassNotFoundException, SQLException, IllegalArgumentException {

        // Validação para Data (somente números e separadores / ou -)
        if (!data.matches("\\d{2}[-/]\\d{2}[-/]\\d{4}")) {
            throw new IllegalArgumentException(
                    "Por favor, insira uma data válida no formato dd/mm/aaaa ou dd-mm-aaaa.");
        }

        // Validação para Hora (somente números no formato HH:mm)
        if (!hora.matches("\\d{2}:\\d{2}")) {
            throw new IllegalArgumentException("Por favor, insira a hora no formato HH:mm.");
        }

        try {
            conectar(); // Estabelece a conexão com o banco de dados
            st = conectar.prepareStatement("INSERT INTO eventos(nome, data, hora, local, descricao) VALUES(?,?,?,?,?)");
            st.setString(1, nome);
            st.setString(2, data);
            st.setString(3, hora);
            st.setString(4, local);
            st.setString(5, descricao);
            st.executeUpdate(); // Executa a inserção no banco de dados
        } catch (SQLException e) {
            throw new SQLException("Erro ao acessar o banco de dados: " + e.getMessage());
        }
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
            throws ClassNotFoundException, SQLException, IllegalArgumentException {

        // Validação para Data (somente números e separadores / ou -)
        if (!data.matches("\\d{2}[-/]\\d{2}[-/]\\d{4}")) {
            throw new IllegalArgumentException(
                    "Por favor, insira uma data válida no formato dd/mm/aaaa ou dd-mm-aaaa.");
        }

        // Validação para Hora (somente números no formato HH:mm)
        if (!hora.matches("\\d{2}:\\d{2}")) {
            throw new IllegalArgumentException("Por favor, insira a hora no formato HH:mm.");
        }

        boolean sucesso = false; // Inicializa como falso

        try {
            conectar(); // Estabelece a conexão com o banco de dados
            st = conectar.prepareStatement(
                    "UPDATE eventos SET nome = ?, data = ?, hora = ?, local = ?, descricao = ? WHERE id_evento = ?");
            st.setString(1, nome);
            st.setString(2, data);
            st.setString(3, hora);
            st.setString(4, local);
            st.setString(5, descricao);
            st.setInt(6, idEvento);
            int rowsUpdated = st.executeUpdate(); // Executa a atualização no banco de dados

            if (rowsUpdated > 0) {
                sucesso = true; // Se a atualização for bem-sucedida, define sucesso como true
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao acessar o banco de dados: " + e.getMessage());
        }

        // Se sucesso for verdadeiro, retorna sucesso, caso contrário, falha
        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Evento editado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao editar evento. Tente novamente.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
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

    // Método para verificar se a programação é válida
    public ResultSet isProgramacaoValida(String data, String horario, String local)
            throws ClassNotFoundException, SQLException {
        conectar();
        st = conectar.prepareStatement("SELECT * FROM programacao WHERE data = ? AND horario = ? AND local = ?");
        st.setString(1, data);
        st.setString(2, horario);
        st.setString(3, local);
        return st.executeQuery();
    }

    // Método para criar Ingresso
    public void criarIngresso(int idFilme, String data, String horario, String local, String vagasStr)
            throws ClassNotFoundException, SQLException {
        boolean sucesso = false; // Inicialmente assume que o processo falhou

        try {
            // Validação se o valor de vagas é um número inteiro
            int vagas = Integer.parseInt(vagasStr); // Tentando converter o texto para inteiro

            // Se a conversão for bem-sucedida, procede com a inserção no banco de dados
            conectar();
            st = conectar.prepareStatement(
                    "INSERT INTO ingressos(fk_id_filme, fk_data, fk_horario, fk_local, vagas) VALUES (?, ?, ?, ?, ?)");
            st.setInt(1, idFilme);
            st.setString(2, data);
            st.setString(3, horario);
            st.setString(4, local);
            st.setInt(5, vagas);
            st.executeUpdate();
            sucesso = true; // Se o ingresso for criado com sucesso, muda o status para true
        } catch (NumberFormatException e) {
            // Exibe uma mensagem de erro se o valor inserido não for um número inteiro
            JOptionPane.showMessageDialog(null, "Por favor, insira um número válido para as vagas!", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            // Caso ocorra algum erro no banco de dados, define sucesso como false
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + e.getMessage());
        } catch (Exception e) {
            // Trata exceções gerais
            JOptionPane.showMessageDialog(null, "Erro desconhecido: " + e.getMessage());
        }

        // Verifica o status de sucesso e exibe a mensagem correta
        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Ingresso criado com sucesso!", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao criar ingresso. Tente novamente.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para listar Ingressos
    public ResultSet listarIngressos() throws ClassNotFoundException, SQLException {
        conectar();
        st = conectar.prepareStatement(
                "SELECT i.id_ingresso, f.titulo, f.diretor, i.fk_data, i.fk_horario, i.fk_local, i.vagas " +
                        "FROM ingressos i " +
                        "INNER JOIN filmes f ON i.fk_id_filme = f.id_filme");
        return st.executeQuery();
    }

    // Método para buscar Ingresso
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

    // Método para editar Ingresso
    public void editarIngresso(int idIngresso, String titulo, String diretor, String data, String horario, String local,
            int vagas) throws ClassNotFoundException, SQLException {
        boolean sucesso = false; // Inicialmente assume que o processo falhou

        try {
            // Se a conversão de vagas para inteiro já foi feita na camada da interface,
            // pode usá-la diretamente
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
            st.setInt(6, vagas); // Agora o tipo é int
            st.setInt(7, idIngresso);
            st.executeUpdate();

            sucesso = true; // Se o ingresso for editado com sucesso, muda o status para true

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um número válido para as vagas!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro desconhecido: " + e.getMessage());
        }

        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Ingresso editado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao editar ingresso. Tente novamente.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para excluir Ingresso
    public void excluirIngresso(int idIngresso) throws ClassNotFoundException, SQLException {
        conectar();
        st = conectar.prepareStatement("DELETE FROM ingressos WHERE id_ingresso = ?");
        st.setInt(1, idIngresso);
        st.executeUpdate();
    }
}