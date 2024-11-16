import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class editarProgramacao extends javax.swing.JFrame {
    private int idProgramacao;

    public editarProgramacao(int idProgramacao) {
        this.idProgramacao = idProgramacao;
        initComponents();
        carregarDados();
    }

    public editarProgramacao() {
        initComponents();
    }

    private void carregarDados() {
        try {
            appData app = new appData();
            ResultSet rs = app.buscarProgramacoesEditar(idProgramacao);
            if (rs.next()) {
                txtTitulo.setText(rs.getString("fk_titulo"));
                txtDiretor2.setText(rs.getString("fk_diretor"));
                txtData.setText(rs.getString("data"));
                txtHora.setText(rs.getString("horario"));
                txtLocal.setText(rs.getString("local"));

                //Desabilitar a edição
                // txtTitulo.setEnabled(false);
                // txtDiretor2.setEnabled(false);
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

    private void btnEditarProgramacaoActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            appData app = new appData();
            app.editarProgramacao(idProgramacao, txtData.getText(), txtHora.getText(), txtLocal.getText());
            JOptionPane.showMessageDialog(null, "Programação editada com sucesso!");
            this.dispose();
        } catch (Exception e) {
            System.out.println("Erro ao editar programação: " + e.getMessage());
        }
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
