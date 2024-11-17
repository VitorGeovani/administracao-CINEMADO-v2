import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @autor vitor.gmsilva1
 */

public class editarSubmissao extends javax.swing.JFrame { // Herança: editarSubmissao herda de JFrame

    private appData app; // Encapsulamento: uso de modificador de acesso private
    private int idFilme; // Encapsulamento: uso de modificador de acesso private

    public editarSubmissao(int idFilme, appData app) { // Construtor
        this.app = app;
        this.idFilme = idFilme;
        initComponents();
        preencherCampos(idFilme);
    }

    private void preencherCampos(int idFilme) {
        try { // Tratamento de Exceção: uso de try-catch
            appData app = new appData();
            ResultSet rs = app.buscarFilme(idFilme);
            if (rs.next()) {
                txtTitulo.setText(rs.getString("titulo"));
                txtDiretor2.setText(rs.getString("diretor"));
                txtDuracao.setText(rs.getString("duracao"));
                cnbGenero.setSelectedItem(rs.getString("genero"));
                txtSinpse.setText(rs.getString("sinopse"));
                txtData.setText(rs.getString("data_lancamento"));
                cnbClassificacao.setSelectedItem(rs.getString("classificacao_indicativa"));
            }
        } catch (Exception e) { // Tratamento de Exceção: captura de exceção genérica
            JOptionPane.showMessageDialog(null, "Erro ao preencher campos!");
        }
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel2 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDiretor2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDuracao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cnbGenero = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtSinpse = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cnbClassificacao = new javax.swing.JComboBox<>();
        btnEditarSubmissao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Título do Filme:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(60, 60, 0, 0);
        getContentPane().add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 206;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(60, 20, 0, 168);
        getContentPane().add(txtTitulo, gridBagConstraints);

        jLabel4.setText("Diretor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 71;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 60, 0, 0);
        getContentPane().add(jLabel4, gridBagConstraints);

        txtDiretor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiretor2ActionPerformed(evt); // Sobrescrita: método actionPerformed sobrescrito
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 236;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 120, 0, 168);
        getContentPane().add(txtDiretor2, gridBagConstraints);

        jLabel1.setText("Duração:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 63;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 60, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        txtDuracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDuracaoActionPerformed(evt); // Sobrescrita: método actionPerformed sobrescrito
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 236;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 120, 0, 168);
        getContentPane().add(txtDuracao, gridBagConstraints);

        jLabel3.setText("Gênero:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 69;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 60, 0, 0);
        getContentPane().add(jLabel3, gridBagConstraints);

        cnbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Romance", "Aventura", "Suspense", "Terror/Horror", "Ação", "Documentário", "Ficção científica", "Drama", "Comédia", "Fantasia", "Musical", "Mistério" }));
        cnbGenero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cnbGeneroItemStateChanged(evt); // Sobrescrita: método itemStateChanged sobrescrito
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 181;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 120, 0, 168);
        getContentPane().add(cnbGenero, gridBagConstraints);

        jLabel6.setText("Sinopse:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 26;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 60, 0, 0);
        getContentPane().add(jLabel6, gridBagConstraints);

        txtSinpse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSinpseActionPerformed(evt); // Sobrescrita: método actionPerformed sobrescrito
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 236;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 120, 0, 168);
        getContentPane().add(txtSinpse, gridBagConstraints);

        jLabel5.setText("Data Lançamento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 60, 0, 0);
        getContentPane().add(jLabel5, gridBagConstraints);

        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt); // Sobrescrita: método actionPerformed sobrescrito
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 166;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 168);
        getContentPane().add(txtData, gridBagConstraints);

        jLabel7.setText("Classificação indicativa:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 60, 0, 0);
        getContentPane().add(jLabel7, gridBagConstraints);

        cnbClassificacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Livre", "10 anos", "12 anos", "14 anos", "16 anos", "18 anos" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 156;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 168);
        getContentPane().add(cnbClassificacao, gridBagConstraints);

        btnEditarSubmissao.setText("Editar Filme");
        btnEditarSubmissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarSubmissaoActionPerformed(evt); // Sobrescrita: método actionPerformed sobrescrito
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 78;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 10, 53, 0);
        getContentPane().add(btnEditarSubmissao, gridBagConstraints);

        setSize(new java.awt.Dimension(604, 491));
        setLocationRelativeTo(null);
    }

    private void txtDiretor2ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void txtDuracaoActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void cnbGeneroItemStateChanged(java.awt.event.ItemEvent evt) {
    }

    private void txtSinpseActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void btnEditarSubmissaoActionPerformed(java.awt.event.ActionEvent evt) {
        try { // Tratamento de Exceção: uso de try-catch
            app.editarFilme(idFilme, txtTitulo.getText(), txtDiretor2.getText(), txtDuracao.getText(),
                    cnbGenero.getSelectedItem().toString(), txtSinpse.getText(), txtData.getText(),
                    cnbClassificacao.getSelectedItem().toString());

            JOptionPane.showMessageDialog(null, "Filme editado com sucesso!");
            this.dispose();
        } catch (Exception e) { // Tratamento de Exceção: captura de exceção genérica
            JOptionPane.showMessageDialog(null, "Erro ao editar filme!" + e.getMessage());
        }

    }

    public static void main(String args[]) {
        try { // Tratamento de Exceção: uso de try-catch
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) { // Tratamento de Exceção: captura de exceção específica
            java.util.logging.Logger.getLogger(editarSubmissao.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) { // Tratamento de Exceção: captura de exceção específica
            java.util.logging.Logger.getLogger(editarSubmissao.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) { // Tratamento de Exceção: captura de exceção específica
            java.util.logging.Logger.getLogger(editarSubmissao.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) { // Tratamento de Exceção: captura de exceção específica
            java.util.logging.Logger.getLogger(editarSubmissao.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() { // Sobrecarga: método run() implementado na classe anônima
            public void run() {
                new editarSubmissao(0, new appData()).setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnEditarSubmissao;
    private javax.swing.JComboBox<String> cnbClassificacao;
    private javax.swing.JComboBox<String> cnbGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtDiretor2;
    private javax.swing.JTextField txtDuracao;
    private javax.swing.JTextField txtSinpse;
    private javax.swing.JTextField txtTitulo;
}