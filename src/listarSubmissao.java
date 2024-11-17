import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vitor.gmsilva1
 */

public class listarSubmissao extends javax.swing.JFrame { // Herança: listarSubmissao herda de javax.swing.JFrame

    appData data;

    public listarSubmissao() {
        initComponents();
        data = new appData();
        carregarDados("Todos");
    }

    public void carregarDados(String genero) {
        try {
            DefaultTableModel model = (DefaultTableModel) tblSubmissoes.getModel();
            model.setRowCount(0);
            ResultSet resultado = data.listarFilmes(genero);
            while (resultado.next()) {
                model.addRow(new Object[] {
                        resultado.getInt("id_filme"),
                        resultado.getString("titulo"),
                        resultado.getString("diretor"),
                        resultado.getString("duracao"),
                        resultado.getString("genero"),
                        resultado.getString("sinopse"),
                        resultado.getString("data_lancamento"),
                        resultado.getString("classificacao_indicativa")
                });
            }
        } catch (ClassNotFoundException | SQLException ex) { // Tratamento de Exceção: captura ClassNotFoundException e SQLException
            JOptionPane.showMessageDialog(null, "Erro ao buscar filmes: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        iblCargo = new javax.swing.JLabel();
        cmbGenero = new javax.swing.JComboBox<>();
        btnListarSubmissoes = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSubmissoes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Filmes Submetidos");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        iblCargo.setText("Gênero:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.ipady = 34;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 180, 0, 0);
        getContentPane().add(iblCargo, gridBagConstraints);

        cmbGenero.setModel(new javax.swing.DefaultComboBoxModel<>( // Encapsulamento: uso de métodos públicos para acessar e modificar cmbGenero
                new String[] { "Romance", "Aventura", "Suspense", "Terror/Horror", "Ação", "Documentário",
                        "Ficção científica", "Drama", "Comédia", "Fantasia", "Musical", "Mistério", "Todos" }));
        cmbGenero.setSelectedItem("Todos");
        cmbGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGeneroActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 51;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 230, 0, 0);
        getContentPane().add(cmbGenero, gridBagConstraints);

        btnListarSubmissoes.setText("Listar");
        btnListarSubmissoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarSubmissoesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 78;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 10, 0, 0);
        getContentPane().add(btnListarSubmissoes, gridBagConstraints);

        tblSubmissoes.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "ID do filme", "Título", "Diretor", "Duração", "Gênero", "Sinopse", "Lançamento",
                        "Classificação"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSubmissoes);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 724;
        gridBagConstraints.ipady = 310;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 56, 7);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        setSize(new java.awt.Dimension(783, 504));
        setLocationRelativeTo(null);
    }

    private void cmbGeneroActionPerformed(java.awt.event.ActionEvent evt) {
        String genero = cmbGenero.getSelectedItem().toString();
        carregarDados(genero);
    }

    private void btnListarSubmissoesActionPerformed(java.awt.event.ActionEvent evt) {
        String genero = cmbGenero.getSelectedItem().toString();
        carregarDados(genero);
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) { // Tratamento de Exceção: captura ClassNotFoundException
            java.util.logging.Logger.getLogger(listarSubmissao.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) { // Tratamento de Exceção: captura InstantiationException
            java.util.logging.Logger.getLogger(listarSubmissao.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) { // Tratamento de Exceção: captura IllegalAccessException
            java.util.logging.Logger.getLogger(listarSubmissao.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) { // Tratamento de Exceção: captura UnsupportedLookAndFeelException
            java.util.logging.Logger.getLogger(listarSubmissao.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listarSubmissao().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnListarSubmissoes;
    private javax.swing.JComboBox<String> cmbGenero;
    private javax.swing.JLabel iblCargo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSubmissoes;
}