import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @autor vitor.gmsilva1
 */
public class editarEvento extends javax.swing.JFrame {
    // Encapsulamento: Atributo privado
    private int idEvento;
    
    // Construtor
    public editarEvento(int idEvento) {
        this.idEvento = idEvento;
        initComponents();
        carregarDados();
    }

    // Método privado para carregar dados
    private void carregarDados() {
        try {
            appData app = new appData();
            ResultSet rs = app.buscarEventosEditar(idEvento);
            if (rs.next()) {
                txtNome.setText(rs.getString("nome"));
                txtData.setText(rs.getString("data"));
                txtHora.setText(rs.getString("hora"));
                txtLocal.setText(rs.getString("local"));
                txtDescricao.setText(rs.getString("descricao"));
            }
        } catch (Exception e) {
            // Tratamento de Exceção
            JOptionPane.showMessageDialog(null, "Erro ao carregar dados do evento: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtLocal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        btnEditarEvento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Nome do evento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 90, 0, 0);
        getContentPane().add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.ipadx = 206;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 0, 0, 114);
        getContentPane().add(txtNome, gridBagConstraints);

        jLabel3.setText("Data:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 90, 0, 0);
        getContentPane().add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 106;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 150, 0, 0);
        getContentPane().add(txtData, gridBagConstraints);

        jLabel5.setText("Hora:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 81;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 90, 0, 0);
        getContentPane().add(jLabel5, gridBagConstraints);

        txtHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 106;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 150, 0, 0);
        getContentPane().add(txtHora, gridBagConstraints);

        jLabel7.setText("Local:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 79;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 90, 0, 0);
        getContentPane().add(jLabel7, gridBagConstraints);

        txtLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocalActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 236;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 150, 0, 0);
        getContentPane().add(txtLocal, gridBagConstraints);

        jLabel4.setText("Descrição:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 56;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 90, 0, 0);
        getContentPane().add(jLabel4, gridBagConstraints);

        txtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 236;
        gridBagConstraints.ipady = 58;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 150, 0, 0);
        getContentPane().add(txtDescricao, gridBagConstraints);

        btnEditarEvento.setText("Editar Evento");
        btnEditarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarEventoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 40, 39, 0);
        getContentPane().add(btnEditarEvento, gridBagConstraints);

        setSize(new java.awt.Dimension(590, 397));
        setLocationRelativeTo(null);
    }

    private void txtHoraActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void txtLocalActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void txtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void btnEditarEventoActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Tenta converter a data e hora para garantir que estão no formato correto
            String data = txtData.getText();
            String hora = txtHora.getText();
    
            // Validações de Data e Hora
            if (!data.matches("\\d{2}[-/]\\d{2}[-/]\\d{4}")) {
                JOptionPane.showMessageDialog(null, "Por favor, insira uma data válida no formato dd/mm/aaaa ou dd-mm-aaaa.", "Erro de validação", JOptionPane.ERROR_MESSAGE);
                return; // Não continua se a data for inválida
            }
    
            if (!hora.matches("\\d{2}:\\d{2}")) {
                JOptionPane.showMessageDialog(null, "Por favor, insira a hora no formato HH:mm.", "Erro de validação", JOptionPane.ERROR_MESSAGE);
                return; // Não continua se a hora for inválida
            }
    
            // Chama o método editarEvento com os dados fornecidos
            appData app = new appData();
            app.editarEvento(idEvento, txtNome.getText(), data, hora, txtLocal.getText(), txtDescricao.getText());
    
            
            this.dispose(); // Fecha a janela de edição
        } catch (IllegalArgumentException e) {
            // Se a data ou hora forem inválidas, exibe a mensagem de erro
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro de validação", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // Captura exceções gerais e mostra uma mensagem genérica de erro
            JOptionPane.showMessageDialog(null, "Erro ao editar evento: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            // Tratamento de Exceção
            java.util.logging.Logger.getLogger(editarEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            // Tratamento de Exceção
            java.util.logging.Logger.getLogger(editarEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            // Tratamento de Exceção
            java.util.logging.Logger.getLogger(editarEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            // Tratamento de Exceção
            java.util.logging.Logger.getLogger(editarEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editarEvento(0).setVisible(true);
            }
        });
    }

    // Encapsulamento: Atributos privados
    private javax.swing.JButton btnEditarEvento;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtLocal;
    private javax.swing.JTextField txtNome;
}