import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vitor.gmsilva1
 */
public class listarEventos extends javax.swing.JFrame { // Herança: listarEventos herda de javax.swing.JFrame
    appData data; // Encapsulamento: atributo privado da classe

    public listarEventos() { // Construtor
        initComponents();
        data = new appData();
        carregarDados();
    }

    private void carregarDados() {
        try { // Tratamento de Exceção: try-catch para tratar ClassNotFoundException e SQLException
            DefaultTableModel model = (DefaultTableModel) tblEventos.getModel();
            model.setRowCount(0);
            ResultSet resultado = data.buscarEventos();
            while (resultado.next()) {
                model.addRow(new Object[]{
                    resultado.getInt("id_evento"),
                    resultado.getString("nome"),
                    resultado.getString("data"),
                    resultado.getString("hora"),
                    resultado.getString("local"),
                    resultado.getString("descricao")
                });
            }
        } catch (ClassNotFoundException | SQLException ex) { // Tratamento de Exceção: captura múltiplas exceções
            JOptionPane.showMessageDialog(null, "Erro ao buscar eventos: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane2 = new javax.swing.JScrollPane();
        tblEventos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Eventos do Festival");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        tblEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID do Evento", "Nome", "Data", "Hora", "Local", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) { // Sobrescrita: sobrescreve o método isCellEditable da classe DefaultTableModel
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblEventos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 804;
        gridBagConstraints.ipady = 310;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(110, 20, 94, 11);
        getContentPane().add(jScrollPane2, gridBagConstraints);

        setSize(new java.awt.Dimension(867, 542));
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        try { // Tratamento de Exceção: try-catch para tratar exceções relacionadas ao LookAndFeel
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(listarEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listarEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listarEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listarEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() { // Classe anônima
            public void run() {
                new listarEventos().setVisible(true);
            }
        });
    }

    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblEventos;
}