import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vitor.gmsilva1
 */

public class listarAvaliacoes extends javax.swing.JFrame { // Herança: listarAvaliacoes herda de javax.swing.JFrame

    appData data;

    public listarAvaliacoes() {
        initComponents();
        data = new appData();
        carregarDados("Todos");
    }

    private void carregarDados(String genero) {
        try { // Tratamento de Exceção: try-catch para capturar ClassNotFoundException e SQLException
            DefaultTableModel model = (DefaultTableModel) tblAvaliacoes.getModel();
            model.setRowCount(0);
            ResultSet resultado = data.listarFilmes(genero);
            while (resultado.next()) {
                model.addRow(new Object[]{
                    resultado.getInt("id_filme"),
                    resultado.getString("titulo"),
                    resultado.getString("genero"),
                    resultado.getString("diretor"),
                    resultado.getString("cinematografia"), 
                    resultado.getString("originalidade"), 
                    resultado.getString("comentario_tecnico")
                });
            }
        } catch (ClassNotFoundException | SQLException ex) { // Tratamento de Exceção: captura múltiplas exceções
            JOptionPane.showMessageDialog(null, "Erro ao buscar filmes: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        iblCargo = new javax.swing.JLabel();
        cmbGenero = new javax.swing.JComboBox<>();
        btnListarAvaliacoes = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAvaliacoes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Avaliações dos Filmes");
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

        cmbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Romance", "Aventura", "Suspense", "Terror/Horror", "Ação", "Documentário", "Ficção científica", "Drama", "Comédia", "Fantasia", "Musical", "Mistério", "Todos" }));
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

        btnListarAvaliacoes.setText("Listar");
        btnListarAvaliacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarAvaliacoesActionPerformed(evt);
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
        getContentPane().add(btnListarAvaliacoes, gridBagConstraints);

        tblAvaliacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID do filme", "Título", "Gênero", "Diretor", "Cinematografia", "Originalidade", "Comentário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAvaliacoes);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 804;
        gridBagConstraints.ipady = 310;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(30, 20, 79, 9);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        setSize(new java.awt.Dimension(865, 537));
        setLocationRelativeTo(null);
    }

    private void cmbGeneroActionPerformed(java.awt.event.ActionEvent evt) {
        String genero = cmbGenero.getSelectedItem().toString();
        carregarDados(genero);
    }

    private void btnListarAvaliacoesActionPerformed(java.awt.event.ActionEvent evt) {
        String genero = cmbGenero.getSelectedItem().toString();
        carregarDados(genero);
    }

    public static void main(String args[]) {
        try { // Tratamento de Exceção: try-catch para capturar exceções relacionadas ao LookAndFeel
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(listarAvaliacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listarAvaliacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listarAvaliacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listarAvaliacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listarAvaliacoes().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnListarAvaliacoes;
    private javax.swing.JComboBox<String> cmbGenero;
    private javax.swing.JLabel iblCargo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAvaliacoes;
}