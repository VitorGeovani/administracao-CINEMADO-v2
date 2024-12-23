import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author vitor.gmsilva1
 */

public class criarIngresso extends javax.swing.JFrame { // Herança: criarIngresso herda de javax.swing.JFrame
    private int idFilme; // Encapsulamento: variável privada

    // Sobrecarga: dois construtores com diferentes assinaturas
    public criarIngresso(int idFilme) {
        this.idFilme = idFilme;
        initComponents();
        carregarDetalhesFilme(idFilme);
    }

    public criarIngresso() {
        initComponents();
    }

    private void carregarDetalhesFilme(int idFilme) {
        try {
            appData app = new appData();
            ResultSet rsFilme = app.getFilmeDetalhes(idFilme);
            if (rsFilme.next()) {
                String titulo = rsFilme.getString("fk_titulo");
                String diretor = rsFilme.getString("fk_diretor");
                String data = rsFilme.getString("data");
                String horario = rsFilme.getString("horario");
                String local = rsFilme.getString("local");
                txtTitulo.setText(titulo);
                txtDiretor.setText(diretor);
                txtData.setText(data);
                txtHora.setText(horario);
                txtLocal.setText(local);

                // Desabilitar campos
                txtTitulo.setEnabled(false);
                txtDiretor.setEnabled(false);
                txtData.setEnabled(false);
                txtHora.setEnabled(false);
                txtLocal.setEnabled(false);
                
            } else {
                JOptionPane.showMessageDialog(this, "Filme não encontrado!");
            }
        } catch (Exception e) { // Tratamento de Exceção
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar detalhes do filme: " + e.getMessage());
        }
    }

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
        jLabel8 = new javax.swing.JLabel();
        txtVagas = new javax.swing.JTextField();
        btnCriarIngresso = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Criar Ingresso");
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
        gridBagConstraints.insets = new java.awt.Insets(30, 150, 0, 105);
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
        gridBagConstraints.insets = new java.awt.Insets(10, 120, 0, 105);
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
        gridBagConstraints.insets = new java.awt.Insets(10, 120, 0, 105);
        getContentPane().add(txtLocal, gridBagConstraints);

        jLabel8.setText("Vagas disponiveis:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 60, 0, 0);
        getContentPane().add(jLabel8, gridBagConstraints);

        txtVagas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVagasActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 186;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 105);
        getContentPane().add(txtVagas, gridBagConstraints);

        btnCriarIngresso.setText("Criar Ingresso");
        btnCriarIngresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarIngressoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 40, 50, 0);
        getContentPane().add(btnCriarIngresso, gridBagConstraints);

        setSize(new java.awt.Dimension(541, 388));
        setLocationRelativeTo(null);
    }

    private void txtDiretorActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void txtHoraActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void txtLocalActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void txtVagasActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void btnCriarIngressoActionPerformed(java.awt.event.ActionEvent evt) {
        String data = txtData.getText();
        String hora = txtHora.getText();
        String local = txtLocal.getText();
        String vagasStr = txtVagas.getText();
    
        try {
            // Validação se o valor de vagas é um número inteiro
            int vagas = Integer.parseInt(vagasStr); // Tentando converter o texto para inteiro
            
            appData app = new appData();
            ResultSet rsProgramacao = app.isProgramacaoValida(data, hora, local);
            
            if (rsProgramacao.next()) {
                app.criarIngresso(idFilme, data, hora, local, String.valueOf(vagas)); // Convertendo vagas para String
                // A mensagem de sucesso ou erro será exibida diretamente na função criarIngresso
    
                // Limpar campos
                txtData.setText("");
                txtHora.setText("");
                txtLocal.setText("");
                txtVagas.setText("");
    
                // Fechar janela
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Programação não encontrada!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            // Se não for possível converter o texto para número, exibe mensagem de erro
            JOptionPane.showMessageDialog(this, "Por favor, insira um número válido para as vagas!", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // Tratamento de Exceção para outras falhas
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao criar ingresso: " + e.getMessage());
        }
    }
    
    
    public static void main(String args[]) {
        try { // Tratamento de Exceção
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) { // Tratamento de Exceção
            java.util.logging.Logger.getLogger(criarIngresso.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) { // Tratamento de Exceção
            java.util.logging.Logger.getLogger(criarIngresso.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) { // Tratamento de Exceção
            java.util.logging.Logger.getLogger(criarIngresso.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) { // Tratamento de Exceção
            java.util.logging.Logger.getLogger(criarIngresso.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new criarIngresso().setVisible(true);
            }
        });
    }

    // Encapsulamento: variáveis privadas
    private javax.swing.JButton btnCriarIngresso;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtDiretor;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtLocal;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtVagas;
}