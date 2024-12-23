import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vitor.gmsilva1
 */

public class listarProgramacao extends javax.swing.JFrame {
    // Variáveis de interface
    private javax.swing.JScrollPane jScrollPane1;

    appData data;

    public listarProgramacao() {
        initComponents();
        data = new appData();
        carregarDados();
    }

    private void carregarDados() {
        try {
            DefaultTableModel model = (DefaultTableModel) tblProgramacoes.getModel();
            model.setRowCount(0);
            ResultSet resultado = data.buscarProgramacoes();
            while (resultado.next()) {
                model.addRow(new Object[]{
                    resultado.getInt("id_filme"),
                    resultado.getString("titulo"),
                    resultado.getString("diretor"),
                    resultado.getString("data"),
                    resultado.getString("horario"),
                    resultado.getString("local")
                });
            }
        } catch (ClassNotFoundException | SQLException ex) {
            // Tratamento de Exceção
            JOptionPane.showMessageDialog(null, "Erro ao buscar programações: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane2 = new javax.swing.JScrollPane();
        tblProgramacoes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Programação dos Filmes");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        tblProgramacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID do filme", "Título", "Diretor", "Data", "Horário", "Local"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblProgramacoes);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 804;
        gridBagConstraints.ipady = 310;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(110, 20, 71, 25);
        getContentPane().add(jScrollPane2, gridBagConstraints);

        setSize(new java.awt.Dimension(881, 519));
        setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(listarProgramacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listarProgramacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listarProgramacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listarProgramacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listarProgramacao().setVisible(true);
            }
        });
    }

    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblProgramacoes;
}