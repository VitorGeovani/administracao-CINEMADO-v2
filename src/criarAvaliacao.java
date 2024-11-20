import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 *
 * @author vitor.gmsilva1
 */

// Herança: A classe criarAvaliacao estende a classe javax.swing.JFrame
public class criarAvaliacao extends javax.swing.JFrame {

    // Variáveis para armazenar os detalhes do filme
    private String tituloFilme;
    private String diretorFilme;
    private String generoFilme;
    private String duracaoFilme;
    private String dataFilme;
    private String classificacaoFilme;
    private static int idFilme;

    // Adicione essas declarações de campo à classe Avaliacao
    private javax.swing.JTextField txtClassificacao;

    // Método para preencher os campos com os detalhes do filme
    private void preencherCamposFilme() {
        txtTitulo.setText(tituloFilme);
        txtDiretor.setText(diretorFilme);
        cnbGenero.setSelectedItem(generoFilme);
        txtDuracao.setText(duracaoFilme);
        txtData.setText(dataFilme);
        // O campo de classificação deve ser preenchido usando a variável classificacaoFilme
        cnbClassificacao.setSelectedItem(classificacaoFilme);
        
        // Desabilitar campos de filme para edição
        txtTitulo.setEnabled(false);
        txtDiretor.setEnabled(false);
        cnbGenero.setEnabled(false);
        txtDuracao.setEnabled(false);
        txtData.setEnabled(false);
        cnbClassificacao.setEnabled(false);
    }

    public criarAvaliacao(int idFilme) {
        this.idFilme = idFilme;
        initComponents();
        carregarDetalhesFilme();
    }

    private void carregarDetalhesFilme() {
        try {
            appData app = new appData();
            ResultSet resultado = app.avaliarFilme(idFilme);
            if (resultado.next()) {
                // Extrair detalhes do filme do ResultSet
                tituloFilme = resultado.getString("titulo");
                diretorFilme = resultado.getString("diretor");
                generoFilme = resultado.getString("genero");
                duracaoFilme = resultado.getString("duracao");
                dataFilme = resultado.getString("data_lancamento");
                classificacaoFilme = resultado.getString("classificacao_indicativa");
                // Preencher automaticamente os campos com os detalhes do filme
                preencherCamposFilme();
                // Habilitar campos de avaliação para edição
                txtCinematografia.setEnabled(true);
                txtOriginalidade.setEnabled(true);
                txtComentario.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Filme não encontrado.");
                dispose(); // Fechar a janela de avaliação se o filme não for encontrado
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao buscar detalhes do filme: " + e.getMessage());
            dispose(); // Fechar a janela de avaliação em caso de erro
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
        btnEnviarAvaliacao = new javax.swing.JButton();

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
        gridBagConstraints.insets = new java.awt.Insets(30, 150, 0, 346);
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
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipadx = 236;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 120, 0, 346);
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

        cnbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Romance", "Aventura", "Suspense", "Terror/Horror", "Ação", "Documentário",
                        "Ficção científica", "Drama", "Comédia", "Fantasia", "Musical", "Mistério" }));
        cnbGenero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
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
        gridBagConstraints.insets = new java.awt.Insets(10, 120, 0, 346);
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
            public void actionPerformed(java.awt.event.ActionEvent evt) {
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
        gridBagConstraints.insets = new java.awt.Insets(10, 120, 0, 346);
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
            public void actionPerformed(java.awt.event.ActionEvent evt) {
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
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 346);
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

        cnbClassificacao.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Livre", "10 anos", "12 anos", "14 anos", "16 anos", "18 anos" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 156;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 346);
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
        gridBagConstraints.insets = new java.awt.Insets(10, 150, 0, 346);
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
        gridBagConstraints.insets = new java.awt.Insets(10, 150, 0, 346);
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
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 346);
        getContentPane().add(txtComentario, gridBagConstraints);

        btnEnviarAvaliacao.setText("Enviar avaliação");
        btnEnviarAvaliacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarAvaliacaoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 76;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 48, 0);
        getContentPane().add(btnEnviarAvaliacao, gridBagConstraints);

        setSize(new java.awt.Dimension(782, 556));
        setLocationRelativeTo(null);
    }

    private void txtDiretorActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void cnbGeneroItemStateChanged(java.awt.event.ItemEvent evt) {
    }

    private void txtDuracaoActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void btnEnviarAvaliacaoActionPerformed(java.awt.event.ActionEvent evt) {
        // Obter os valores dos campos de avaliação
        String cinematografia = txtCinematografia.getText();
        String originalidade = txtOriginalidade.getText();
        String comentario = txtComentario.getText();
    
        // Verificar se os campos de Cinematografia e Originalidade são válidos (somente números, ponto ou vírgula)
        if (!cinematografia.matches("[0-9,\\.]+") || !originalidade.matches("[0-9,\\.]+")) {
            JOptionPane.showMessageDialog(null, "Por favor, insira apenas números com ponto ou vírgula para Cinematografia e Originalidade.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        // Verificar se todos os campos estão preenchidos
        if (cinematografia.isEmpty() || originalidade.isEmpty() || comentario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos de avaliação.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        try {
            // Enviar a avaliação para o banco de dados
            appData app = new appData();
            app.submeterAvaliacao(idFilme, cinematografia, originalidade, comentario);
    
            // Mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Avaliação enviada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    
            // Fechar a janela após o envio
            dispose();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao enviar avaliação: " + e.getMessage());
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
            java.util.logging.Logger.getLogger(criarAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(criarAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(criarAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(criarAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new criarAvaliacao(idFilme).setVisible(true);
            }
        });
    }

    // Encapsulamento: Atributos privados da classe criarAvaliacao
    private javax.swing.JButton btnEnviarAvaliacao;
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
