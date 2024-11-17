import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vitor.gmsilva1
 */

public class listarIngressos extends javax.swing.JFrame { // Herança: listarIngressos herda de javax.swing.JFrame
    appData data; // Encapsulamento: atributo privado da classe

    public listarIngressos() {
        initComponents();
        data = new appData();
        carregarDados();
    }

    private void carregarDados() {
        try { // Tratamento de Exceção: bloco try-catch para tratar possíveis exceções
            DefaultTableModel model = (DefaultTableModel) tbIngressos.getModel();
            model.setRowCount(0);
            ResultSet resultado = data.listarIngressos();
            while (resultado.next()) {
                model.addRow(new Object[]{
                    resultado.getInt("id_ingresso"),
                    resultado.getString("titulo"),
                    resultado.getString("diretor"),
                    resultado.getString("fk_data"),
                    resultado.getString("fk_horario"),
                    resultado.getString("fk_local"),
                    resultado.getInt("vagas")
                });
            }
        } catch (ClassNotFoundException | SQLException ex) { // Tratamento de Exceção: captura de exceções específicas
            JOptionPane.showMessageDialog(null, "Erro ao buscar ingressos: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane2 = new javax.swing.JScrollPane();
        tbIngressos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Filmes em Cartaz");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        tbIngressos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID do Ingresso", "Título", "Diretor", "Data", "Hora", "Local", "Vagas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbIngressos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 804;
        gridBagConstraints.ipady = 310;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(110, 20, 165, 17);
        getContentPane().add(jScrollPane2, gridBagConstraints);

        setSize(new java.awt.Dimension(873, 613));
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        
        try { // Tratamento de Exceção: bloco try-catch para tratar possíveis exceções
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) { // Tratamento de Exceção: captura de exceções específicas
            java.util.logging.Logger.getLogger(listarIngressos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) { // Tratamento de Exceção: captura de exceções específicas
            java.util.logging.Logger.getLogger(listarIngressos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) { // Tratamento de Exceção: captura de exceções específicas
            java.util.logging.Logger.getLogger(listarIngressos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) { // Tratamento de Exceção: captura de exceções específicas
            java.util.logging.Logger.getLogger(listarIngressos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listarIngressos().setVisible(true);
            }
        });
    }

    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbIngressos;
}