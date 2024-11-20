import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author vitor.gmsilva1
 */

public class criarProgramacao extends javax.swing.JFrame { // Herança: criarProgramacao herda de javax.swing.JFrame
    private int idFilme; // Encapsulamento: variável privada

    public criarProgramacao(int idFilme) { // Sobrecarga: construtor com parâmetro
        this.idFilme = idFilme;
        initComponents();
        carregarDadosFilme(idFilme);
    }

    private void carregarDadosFilme(int idFilme) {
        try { // Tratamento de Exceção: bloco try-catch
            appData app = new appData();
            ResultSet rs = app.buscarFilmePorId(idFilme);
            if (rs.next()) {
                txtTitulo.setText(rs.getString("titulo"));
                txtDiretor.setText(rs.getString("diretor"));
            }
        } catch (Exception e) { // Tratamento de Exceção: captura de exceção genérica
            JOptionPane.showMessageDialog(null, "Erro ao carregar dados do filme!");
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel2 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDiretor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtLocal = new javax.swing.JTextField();
        btnEnviarProgramacao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Criar Programação");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Título do Filme:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 60, 0, 0);
        getContentPane().add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 206;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 150, 0, 81);
        getContentPane().add(txtTitulo, gridBagConstraints);

        jLabel4.setText("Diretor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 71;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 60, 0, 0);
        getContentPane().add(jLabel4, gridBagConstraints);

        txtDiretor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiretorActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 236;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 120, 0, 81);
        getContentPane().add(txtDiretor, gridBagConstraints);

        jLabel3.setText("Data:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 60, 0, 0);
        getContentPane().add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 106;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 120, 0, 0);
        getContentPane().add(txtData, gridBagConstraints);

        jLabel5.setText("Hora:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 81;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 60, 0, 0);
        getContentPane().add(jLabel5, gridBagConstraints);

        txtHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 106;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 120, 0, 0);
        getContentPane().add(txtHora, gridBagConstraints);

        jLabel7.setText("Local:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 79;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 60, 0, 0);
        getContentPane().add(jLabel7, gridBagConstraints);

        txtLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocalActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 236;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 120, 0, 81);
        getContentPane().add(txtLocal, gridBagConstraints);

        btnEnviarProgramacao.setText("Enviar  Programação");
        btnEnviarProgramacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarProgramacaoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 76, 0);
        getContentPane().add(btnEnviarProgramacao, gridBagConstraints);

        setSize(new java.awt.Dimension(517, 364));
        setLocationRelativeTo(null);
    }

    private void txtDiretorActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void txtHoraActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void txtLocalActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void btnEnviarProgramacaoActionPerformed(java.awt.event.ActionEvent evt) {
        String data = txtData.getText();
        String hora = txtHora.getText();
        String local = txtLocal.getText();
        String titulo = txtTitulo.getText();
        String diretor = txtDiretor.getText();
    
        // Validação de Data (formato dd/mm/aaaa ou dd-mm-aaaa)
        if (!validarData(data)) {
            JOptionPane.showMessageDialog(null, "Erro: Data inválida! Use o formato dd/mm/aaaa ou dd-mm-aaaa.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return; // Interrompe a execução se a validação falhar
        }
    
        // Validação de Hora (formato hh:mm)
        if (!validarHora(hora)) {
            JOptionPane.showMessageDialog(null, "Erro: Hora inválida! Use o formato hh:mm.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return; // Interrompe a execução se a validação falhar
        }
    
        try {
            new appData().criarProgramacao(idFilme, titulo, diretor, data, hora, local);
            JOptionPane.showMessageDialog(null, "Programação enviada com sucesso!");
    
            // Limpa os campos após envio
            txtTitulo.setText("");
            txtDiretor.setText("");
            txtData.setText("");
            txtHora.setText("");
            txtLocal.setText("");

            // Fecha a janela após envio
            this.dispose();
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar localizar o Driver JDBC");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar criar a programação: " + e.getMessage());
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
    

    public static void main(String args[]) {
        try { // Tratamento de Exceção: bloco try-catch
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) { // Tratamento de Exceção: captura de exceção específica
            java.util.logging.Logger.getLogger(criarProgramacao.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) { // Tratamento de Exceção: captura de exceção específica
            java.util.logging.Logger.getLogger(criarProgramacao.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) { // Tratamento de Exceção: captura de exceção específica
            java.util.logging.Logger.getLogger(criarProgramacao.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) { // Tratamento de Exceção: captura de exceção específica
            java.util.logging.Logger.getLogger(criarProgramacao.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new criarProgramacao(0).setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnEnviarProgramacao; // Encapsulamento: variáveis privadas
    private javax.swing.JLabel jLabel2; // Encapsulamento: variáveis privadas
    private javax.swing.JLabel jLabel3; // Encapsulamento: variáveis privadas
    private javax.swing.JLabel jLabel4; // Encapsulamento: variáveis privadas
    private javax.swing.JLabel jLabel5; // Encapsulamento: variáveis privadas
    private javax.swing.JLabel jLabel7; // Encapsulamento: variáveis privadas
    private javax.swing.JTextField txtData; // Encapsulamento: variáveis privadas
    private javax.swing.JTextField txtDiretor; // Encapsulamento: variáveis privadas
    private javax.swing.JTextField txtHora; // Encapsulamento: variáveis privadas
    private javax.swing.JTextField txtLocal; // Encapsulamento: variáveis privadas
    private javax.swing.JTextField txtTitulo; // Encapsulamento: variáveis privadas
}