import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author vitor.gmsilva1
 */

public class editarProgramacao extends javax.swing.JFrame {
    // Encapsulamento: atributo privado
    private int idProgramacao;

    // Sobrecarga: dois construtores com assinaturas diferentes
    public editarProgramacao(int idProgramacao) {
        this.idProgramacao = idProgramacao;
        initComponents();
        carregarDados();
    }

    public editarProgramacao() {
        initComponents();
    }

    // Tratamento de Exceção: bloco try-catch
    private void carregarDados() {
        try {
            appData app = new appData();
            ResultSet rs = app.buscarProgramacoesEditar(idProgramacao);
            
            if (rs.next()) {
                // Atribuindo os valores aos campos de texto
                txtTitulo.setText(rs.getString("fk_titulo"));
                txtDiretor2.setText(rs.getString("fk_diretor"));
                txtData.setText(rs.getString("data"));
                txtHora.setText(rs.getString("horario"));
                txtLocal.setText(rs.getString("local"));
            } else {
                // Caso não encontre dados para o ID informado
                JOptionPane.showMessageDialog(null, "Nenhuma programação encontrada para o ID informado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar dados da programação: " + e.getMessage());
        }
    }
    

    @SuppressWarnings("unchecked")
    private void initComponents() {
        // Componentes
        jLabel2 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDiretor2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtLocal = new javax.swing.JTextField();
        btnEditarProgramacao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Programação");
        getContentPane().setLayout(null);

        // Título
        jLabel2.setText("Título do Filme:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 30, 100, 30);
        txtTitulo.setEnabled(false);
        getContentPane().add(txtTitulo);
        txtTitulo.setBounds(150, 30, 270, 30);

        // Diretor
        jLabel4.setText("Diretor:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 70, 110, 30);
        txtDiretor2.setEnabled(false); // Desabilitado para edição
        getContentPane().add(txtDiretor2);
        txtDiretor2.setBounds(120, 70, 300, 30);

        // Data
        jLabel3.setText("Data:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 110, 100, 30);
        getContentPane().add(txtData);
        txtData.setBounds(120, 110, 170, 30);

        // Hora
        jLabel5.setText("Hora:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 150, 110, 30);
        getContentPane().add(txtHora);
        txtHora.setBounds(120, 150, 170, 30);

        // Local
        jLabel7.setText("Local:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(60, 190, 110, 30);
        getContentPane().add(txtLocal);
        txtLocal.setBounds(120, 190, 300, 30);

        // Botão de editar programação
        btnEditarProgramacao.setText("Editar Programação");
        btnEditarProgramacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProgramacaoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditarProgramacao);
        btnEditarProgramacao.setBounds(180, 240, 150, 40);

        // Definição do tamanho da janela
        setSize(new java.awt.Dimension(520, 339));
        // Centralização da janela
        setLocationRelativeTo(null);
    }

    // Tratamento de Exceção: bloco try-catch
private void btnEditarProgramacaoActionPerformed(java.awt.event.ActionEvent evt) {
    // Validação para garantir que a data e a hora não contenham letras
    if (!validarData(txtData.getText())) {
        JOptionPane.showMessageDialog(null, "Erro: Data inválida! Use o formato dd/mm/aaaa ou dd-mm-aaaa, contendo apenas números.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        return; // Interrompe a execução se a validação falhar
    }
    
    if (!validarHora(txtHora.getText())) {
        JOptionPane.showMessageDialog(null, "Erro: Hora inválida! Use o formato hh:mm, contendo apenas números.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        return; // Interrompe a execução se a validação falhar
    }

    try {
        appData app = new appData();
        app.editarProgramacao(idProgramacao, txtData.getText(), txtHora.getText(), txtLocal.getText());
        JOptionPane.showMessageDialog(null, "Programação editada com sucesso!");
        this.dispose();
    } catch (Exception e) {
        System.out.println("Erro ao editar programação: " + e.getMessage());
    }
}

// Função para validar a Data (dd/mm/aaaa ou dd-mm-aaaa)
private boolean validarData(String data) {
    // Verifica se a data contém apenas números e está no formato correto
    String regexData = "^(0[1-9]|[12][0-9]|3[01])[-/]((0[1-9])|(1[0-2]))[-/][0-9]{4}$";
    return data.matches(regexData);
}

// Função para validar a Hora (hh:mm)
private boolean validarHora(String hora) {
    // Verifica se a hora contém apenas números e está no formato correto
    String regexHora = "^([01]?[0-9]|2[0-3]):([0-5][0-9])$";
    return hora.matches(regexHora);
}


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editarProgramacao().setVisible(true);
            }
        });
    }

    // Declaração dos componentes
    private javax.swing.JButton btnEditarProgramacao;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtDiretor2;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtLocal;
    private javax.swing.JTextField txtTitulo;
}