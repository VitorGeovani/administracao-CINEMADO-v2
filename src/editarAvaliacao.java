import java.sql.ResultSet;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author vitor.gmsilva1
 */
public class editarAvaliacao extends javax.swing.JFrame { // Herança: editarAvaliacao herda de JFrame

    private int idAvaliacao; // Encapsulamento: atributo privado

    public editarAvaliacao(int idAvaliacao) { // Construtor
        this.idAvaliacao = idAvaliacao;
        initComponents();
        carregarDadosAvaliacao(idAvaliacao);
    }

    private void carregarDadosAvaliacao(int idAvaliacao) {
        try { // Tratamento de Exceção: bloco try-catch
            appData app = new appData();
            ResultSet rs = app.buscarAvaliacao(idAvaliacao);
            if (rs.next()) {
                txtTitulo.setText(rs.getString("titulo"));
                txtDiretor.setText(rs.getString("diretor"));
                cnbGenero.setSelectedItem(rs.getString("genero"));
                txtDuracao.setText(rs.getString("duracao"));
                txtData.setText(rs.getString("data_lancamento"));
                cnbClassificacao.setSelectedItem(rs.getString("classificacao_indicativa"));
                // Desabilitar edição dos campos que não devem ser editados
                txtTitulo.setEnabled(false);
                txtDiretor.setEnabled(false);
                cnbGenero.setEnabled(false);
                txtDuracao.setEnabled(false);
                txtData.setEnabled(false);
                cnbClassificacao.setEnabled(false);
                // Permitir a edição dos campos desejados
                txtCinematografia.setText(rs.getString("cinematografia"));
                txtOriginalidade.setText(rs.getString("originalidade"));
                txtComentario.setText(rs.getString("comentario_tecnico"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher campos!" + e.getMessage());
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
        cnbGenero = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtDuracao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cnbClassificacao = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtCinematografia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtOriginalidade = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtComentario = new javax.swing.JTextField();
        btnEditarAvaliacao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipadx = 206;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 150, 0, 376);
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
            public void actionPerformed(java.awt.event.ActionEvent evt) { // Sobrecarga: método actionPerformed com diferentes parâmetros
                txtDiretorActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipadx = 236;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 120, 0, 376);
        getContentPane().add(txtDiretor, gridBagConstraints);

        jLabel3.setText("Gênero:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 69;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 60, 0, 0);
        getContentPane().add(jLabel3, gridBagConstraints);

        cnbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Romance", "Aventura", "Suspense", "Terror/Horror", "Ação", "Documentário", "Ficção científica", "Drama", "Comédia", "Fantasia", "Musical", "Mistério" }));
        cnbGenero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) { // Sobrecarga: método itemStateChanged com diferentes parâmetros
                cnbGeneroItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipadx = 181;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 120, 0, 376);
        getContentPane().add(cnbGenero, gridBagConstraints);

        jLabel1.setText("Duração:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 63;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 60, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        txtDuracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { // Sobrecarga: método actionPerformed com diferentes parâmetros
                txtDuracaoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipadx = 236;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 120, 0, 376);
        getContentPane().add(txtDuracao, gridBagConstraints);

        jLabel5.setText("Data Lançamento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 60, 0, 0);
        getContentPane().add(jLabel5, gridBagConstraints);

        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { // Sobrecarga: método actionPerformed com diferentes parâmetros
                txtDataActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 166;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 376);
        getContentPane().add(txtData, gridBagConstraints);

        jLabel7.setText("Classificação indicativa:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 60, 0, 0);
        getContentPane().add(jLabel7, gridBagConstraints);

        cnbClassificacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Livre", "10 anos", "12 anos", "14 anos", "16 anos", "18 anos" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 156;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 376);
        getContentPane().add(cnbClassificacao, gridBagConstraints);

        jLabel8.setText("Cinematografia:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 60, 0, 0);
        getContentPane().add(jLabel8, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipadx = 206;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 150, 0, 376);
        getContentPane().add(txtCinematografia, gridBagConstraints);

        jLabel9.setText("Originalidade:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 26;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 60, 0, 0);
        getContentPane().add(jLabel9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipadx = 206;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 150, 0, 376);
        getContentPane().add(txtOriginalidade, gridBagConstraints);

        jLabel10.setText("Comentário Técnico:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 60, 0, 0);
        getContentPane().add(jLabel10, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 176;
        gridBagConstraints.ipady = 68;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 376);
        getContentPane().add(txtComentario, gridBagConstraints);

        btnEditarAvaliacao.setText("Editar Avaliação");
        btnEditarAvaliacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) { // Sobrecarga: método actionPerformed com diferentes parâmetros
                btnEditarAvaliacaoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 76;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 12, 0);
        getContentPane().add(btnEditarAvaliacao, gridBagConstraints);

        setSize(new java.awt.Dimension(812, 613));
        setLocationRelativeTo(null);
    }

    private void txtDiretorActionPerformed(java.awt.event.ActionEvent evt) { // Sobrecarga: método actionPerformed com diferentes parâmetros
    }

    private void cnbGeneroItemStateChanged(java.awt.event.ItemEvent evt) { // Sobrecarga: método itemStateChanged com diferentes parâmetros
    }

    private void txtDuracaoActionPerformed(java.awt.event.ActionEvent evt) { // Sobrecarga: método actionPerformed com diferentes parâmetros
    }

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) { // Sobrecarga: método actionPerformed com diferentes parâmetros
    }

    private void btnEditarAvaliacaoActionPerformed(java.awt.event.ActionEvent evt) {
        try { // Tratamento de Exceção: bloco try-catch
            appData app = new appData();
            app.editarAvali(
                idAvaliacao,
                txtTitulo.getText(),
                txtDiretor.getText(),
                cnbGenero.getSelectedItem().toString(),
                txtDuracao.getText(),
                txtData.getText(),
                cnbClassificacao.getSelectedItem().toString(),
                txtCinematografia.getText(),
                txtOriginalidade.getText(),
                txtComentario.getText()
            );
            JOptionPane.showMessageDialog(null, "Avaliação editada com sucesso!");
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar avaliação!");
        }
    }

    public static void main(String args[]) {
        try { // Tratamento de Exceção: bloco try-catch
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(editarAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editarAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editarAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editarAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editarAvaliacao(0).setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnEditarAvaliacao;
    private javax.swing.JComboBox<String> cnbClassificacao;
    private javax.swing.JComboBox<String> cnbGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCinematografia;
    private javax.swing.JTextField txtComentario;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtDiretor;
    private javax.swing.JTextField txtDuracao;
    private javax.swing.JTextField txtOriginalidade;
    private javax.swing.JTextField txtTitulo;
}