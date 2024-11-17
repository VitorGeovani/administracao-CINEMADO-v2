import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author gabrielle.ddutra
 */

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuAvaliacoes = new javax.swing.JMenu();
        itmCriarAvaliacao = new javax.swing.JMenuItem();
        itmListarAvaliacao = new javax.swing.JMenuItem();
        itmEditarAvaliacao = new javax.swing.JMenuItem();
        itmExcluirAvaliacao = new javax.swing.JMenuItem();
        mnuSubmissoes = new javax.swing.JMenu();
        itmCriarSubmissao = new javax.swing.JMenuItem();
        itmListarSubmissao = new javax.swing.JMenuItem();
        itmEditarSubmissao = new javax.swing.JMenuItem();
        itmExcluirSubmissao = new javax.swing.JMenuItem();
        mnuProgramacoes = new javax.swing.JMenu();
        itmCriarProgramacao = new javax.swing.JMenuItem();
        itmListarProgramacao = new javax.swing.JMenuItem();
        itmEditarProgramacao = new javax.swing.JMenuItem();
        itmExcluirProgramacao = new javax.swing.JMenuItem();
        mnuIngressos = new javax.swing.JMenu();
        itmCriarIngresso = new javax.swing.JMenuItem();
        itmListarIngresso = new javax.swing.JMenuItem();
        itmEditarIngresso = new javax.swing.JMenuItem();
        itmExcluirIngresso = new javax.swing.JMenuItem();
        mnuEventos = new javax.swing.JMenu();
        itmCriarEvento = new javax.swing.JMenuItem();
        itmListarEvento = new javax.swing.JMenuItem();
        itmEditarEvento = new javax.swing.JMenuItem();
        itmExcluirEvento = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu de Administração");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo-cinemado-administracao.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -5;
        gridBagConstraints.ipady = -22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 70, 39, 42);
        getContentPane().add(jLabel1, gridBagConstraints);

        mnuAvaliacoes.setText("Avaliações");

        itmCriarAvaliacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/address-card-solid-v2.png"))); // NOI18N
        itmCriarAvaliacao.setText("Criar");
        itmCriarAvaliacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmCriarAvaliacaoActionPerformed(evt);
            }
        });
        mnuAvaliacoes.add(itmCriarAvaliacao);

        itmListarAvaliacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/list-solid-v2.png"))); // NOI18N
        itmListarAvaliacao.setText("Listar");
        itmListarAvaliacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmListarAvaliacaoActionPerformed(evt);
            }
        });
        mnuAvaliacoes.add(itmListarAvaliacao);

        itmEditarAvaliacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pen-to-square-solid-v2.png"))); // NOI18N
        itmEditarAvaliacao.setText("Editar");
        itmEditarAvaliacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmEditarAvaliacaoActionPerformed(evt);
            }
        });
        mnuAvaliacoes.add(itmEditarAvaliacao);

        itmExcluirAvaliacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trash-solid-v2.png"))); // NOI18N
        itmExcluirAvaliacao.setText("Excluir");
        itmExcluirAvaliacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmExcluirAvaliacaoActionPerformed(evt);
            }
        });
        mnuAvaliacoes.add(itmExcluirAvaliacao);

        jMenuBar1.add(mnuAvaliacoes);

        mnuSubmissoes.setText("Submissões");

        itmCriarSubmissao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/address-card-solid-v2.png"))); // NOI18N
        itmCriarSubmissao.setText("Criar");
        itmCriarSubmissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmCriarSubmissaoActionPerformed(evt);
            }
        });
        mnuSubmissoes.add(itmCriarSubmissao);

        itmListarSubmissao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/list-solid-v2.png"))); // NOI18N
        itmListarSubmissao.setText("Listar");
        itmListarSubmissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmListarSubmissaoActionPerformed(evt);
            }
        });
        mnuSubmissoes.add(itmListarSubmissao);

        itmEditarSubmissao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pen-to-square-solid-v2.png"))); // NOI18N
        itmEditarSubmissao.setText("Editar");
        itmEditarSubmissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmEditarSubmissaoActionPerformed(evt);
            }
        });
        mnuSubmissoes.add(itmEditarSubmissao);

        itmExcluirSubmissao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trash-solid-v2.png"))); // NOI18N
        itmExcluirSubmissao.setText("Excluir");
        itmExcluirSubmissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmExcluirSubmissaoActionPerformed(evt);
            }
        });
        mnuSubmissoes.add(itmExcluirSubmissao);

        jMenuBar1.add(mnuSubmissoes);

        mnuProgramacoes.setText("Programações");

        itmCriarProgramacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/address-card-solid-v2.png"))); // NOI18N
        itmCriarProgramacao.setText("Criar");
        itmCriarProgramacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmCriarProgramacaoActionPerformed(evt);
            }
        });
        mnuProgramacoes.add(itmCriarProgramacao);

        itmListarProgramacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/list-solid-v2.png"))); // NOI18N
        itmListarProgramacao.setText("Listar");
        itmListarProgramacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmListarProgramacaoActionPerformed(evt);
            }
        });
        mnuProgramacoes.add(itmListarProgramacao);

        itmEditarProgramacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pen-to-square-solid-v2.png"))); // NOI18N
        itmEditarProgramacao.setText("Editar");
        itmEditarProgramacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmEditarProgramacaoActionPerformed(evt);
            }
        });
        mnuProgramacoes.add(itmEditarProgramacao);

        itmExcluirProgramacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trash-solid-v2.png"))); // NOI18N
        itmExcluirProgramacao.setText("Excluir");
        itmExcluirProgramacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmExcluirProgramacaoActionPerformed(evt);
            }
        });
        mnuProgramacoes.add(itmExcluirProgramacao);

        jMenuBar1.add(mnuProgramacoes);

        mnuIngressos.setText("Ingressos");

        itmCriarIngresso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/address-card-solid-v2.png"))); // NOI18N
        itmCriarIngresso.setText("Criar");
        itmCriarIngresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmCriarIngressoActionPerformed(evt);
            }
        });
        mnuIngressos.add(itmCriarIngresso);

        itmListarIngresso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/list-solid-v2.png"))); // NOI18N
        itmListarIngresso.setText("Listar");
        itmListarIngresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmListarIngressoActionPerformed(evt);
            }
        });
        mnuIngressos.add(itmListarIngresso);

        itmEditarIngresso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pen-to-square-solid-v2.png"))); // NOI18N
        itmEditarIngresso.setText("Editar");
        itmEditarIngresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmEditarIngressoActionPerformed(evt);
            }
        });
        mnuIngressos.add(itmEditarIngresso);

        itmExcluirIngresso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trash-solid-v2.png"))); // NOI18N
        itmExcluirIngresso.setText("Excluir");
        itmExcluirIngresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmExcluirIngressoActionPerformed(evt);
            }
        });
        mnuIngressos.add(itmExcluirIngresso);

        jMenuBar1.add(mnuIngressos);

        mnuEventos.setText("Eventos");

        itmCriarEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/address-card-solid-v2.png"))); // NOI18N
        itmCriarEvento.setText("Criar");
        itmCriarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmCriarEventoActionPerformed(evt);
            }
        });
        mnuEventos.add(itmCriarEvento);

        itmListarEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/list-solid-v2.png"))); // NOI18N
        itmListarEvento.setText("Listar");
        itmListarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmListarEventoActionPerformed(evt);
            }
        });
        mnuEventos.add(itmListarEvento);

        itmEditarEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pen-to-square-solid-v2.png"))); // NOI18N
        itmEditarEvento.setText("Editar");
        itmEditarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmEditarEventoActionPerformed(evt);
            }
        });
        mnuEventos.add(itmEditarEvento);

        itmExcluirEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trash-solid-v2.png"))); // NOI18N
        itmExcluirEvento.setText("Excluir");
        itmExcluirEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmExcluirEventoActionPerformed(evt);
            }
        });
        mnuEventos.add(itmExcluirEvento);

        jMenuBar1.add(mnuEventos);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(558, 410));
        setLocationRelativeTo(null);
    }

    /* AVALIAÇÃO */
    private void itmCriarAvaliacaoActionPerformed(java.awt.event.ActionEvent evt) {
        // Solicitar ao usuário que insira o ID do filme
        String idInput = JOptionPane.showInputDialog("Digite o ID do filme que deseja avaliar:");
        // Verificar se o usuário inseriu algum valor
        if (idInput != null && !idInput.isEmpty()) {
            int idFilme = Integer.parseInt(idInput);
            // Abrir a tela de avaliação com o ID do filme
            new criarAvaliacao(idFilme).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "ID do filme não fornecido.");
        }
    }

    private void itmListarAvaliacaoActionPerformed(java.awt.event.ActionEvent evt) {
        new listarAvaliacoes().setVisible(true);
    }

    private void itmEditarAvaliacaoActionPerformed(java.awt.event.ActionEvent evt) {
        // Solicitar ao usuário que insira o ID da avaliação
        String idInput = JOptionPane.showInputDialog("Digite o ID da avaliação que deseja editar:");
        // Verificar se o usuário inseriu algum valor
        if (idInput != null && !idInput.isEmpty()) {
            try {
                int idAvaliacao = Integer.parseInt(idInput);
                // Abrir a tela de edição com o ID da avaliação
                new editarAvaliacao(idAvaliacao).setVisible(true);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID da avaliação inválido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "ID da avaliação não fornecido.");
        }
    }

    private void itmExcluirAvaliacaoActionPerformed(java.awt.event.ActionEvent evt) {
        // Solicitar ao usuário que insira o ID da avaliação
        int id;
        String idInput = JOptionPane.showInputDialog("Digite o ID da avaliação que deseja excluir:");
        if (idInput != null && !idInput.isEmpty()) {
            id = Integer.parseInt(idInput);
            try {
                new appData().excluirAvaliacao(id);
                // Avisar o usuário se os dados foram excluídos
                JOptionPane.showMessageDialog(null, "Avaliação excluída com sucesso");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar localizar o Driver JDBC");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na conexão com o Banco de dados:" + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "ID da avaliação não fornecido.");
        }
    }

    /* SUBMISSÃO */
    private void itmCriarSubmissaoActionPerformed(java.awt.event.ActionEvent evt) {
        new criarSubmissao().setVisible(true);
    }

    private void itmListarSubmissaoActionPerformed(java.awt.event.ActionEvent evt) {
        new listarSubmissao().setVisible(true);
    }

    private void itmEditarSubmissaoActionPerformed(java.awt.event.ActionEvent evt) {
        // Solicitar ao usuário que insira o ID da submissão
        String idInput = JOptionPane.showInputDialog("Digite o ID da submissão que deseja editar:");
        // Verificar se o usuário inseriu algum valor
        if (idInput != null && !idInput.isEmpty()) {
            int idSubmissao = Integer.parseInt(idInput);
            // Declare and initialize the variable 'app'
            appData app = new appData();
            // Abrir a tela de edição com o ID da submissão e a instância de appData
            new editarSubmissao(idSubmissao, app).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "ID da submissão não fornecido.");
        }
    }

    private void itmExcluirSubmissaoActionPerformed(java.awt.event.ActionEvent evt) {
        // Solicitar ao usuário que insira o ID da submissão
        int id;
        String idInput = JOptionPane.showInputDialog("Digite o ID da submissão que deseja excluir:");
        if (idInput != null && !idInput.isEmpty()) {
            id = Integer.parseInt(idInput);
            try {
                new appData().excluirSubmissao(id);
                // Avisar o usuário se os dados foram excluídos
                JOptionPane.showMessageDialog(null, "Submissão excluída com sucesso");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar localizar o Driver JDBC");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na conexão com o Banco de dados:" + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "ID da submissão não fornecido.");
        }
    }

    /* PROGRAMAÇÃO */
    private void itmCriarProgramacaoActionPerformed(java.awt.event.ActionEvent evt) {
        // Solicitar ao usuário que insira o ID do filme para criar a Programação
        String idInput = JOptionPane.showInputDialog("Digite o ID do filme que deseja criar a programação:");
        // Verificar se o usuário inseriu algum valor
        if (idInput != null && !idInput.isEmpty()) {
            try {
                int idFilme = Integer.parseInt(idInput);
                // Abrir a tela de programação com o ID do filme
                new criarProgramacao(idFilme).setVisible(true);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID do filme inválido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "ID do filme não fornecido.");
        }
    }

    private void itmListarProgramacaoActionPerformed(java.awt.event.ActionEvent evt) {
        new listarProgramacao().setVisible(true);
    }

    private void itmEditarProgramacaoActionPerformed(java.awt.event.ActionEvent evt) {
        String idInput = JOptionPane.showInputDialog("Digite o ID da programação que deseja editar:");
        if (idInput != null && !idInput.isEmpty()) {
            try {
                int idProgramacao = Integer.parseInt(idInput);
                new editarProgramacao(idProgramacao).setVisible(true);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID da programação inválido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "ID da programação não fornecido.");
        }
    }

    private void itmExcluirProgramacaoActionPerformed(java.awt.event.ActionEvent evt) {
        // Solicitar ao usuário que insira o ID da programação
        int id;
        String idInput = JOptionPane.showInputDialog("Digite o ID da programação que deseja excluir:");
        if (idInput != null && !idInput.isEmpty()) {
            id = Integer.parseInt(idInput);
            try {
                new appData().excluirProgramacao(id);
                // Avisar o usuário se os dados foram excluídos
                JOptionPane.showMessageDialog(null, "Programação excluída com sucesso");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar localizar o Driver JDBC");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na conexão com o Banco de dados:" + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "ID da programação não fornecido.");
        }
    }

    /* INGRESSOS */
    private void itmCriarIngressoActionPerformed(java.awt.event.ActionEvent evt) {
        // Solicitar ao usuário que insira o ID do filme
        String idInput = JOptionPane.showInputDialog("Digite o ID do filme que deseja criar o ingresso:");
        // Verificar se o usuário inseriu algum valor
        if (idInput != null && !idInput.isEmpty()) {
            try {
                int idFilme = Integer.parseInt(idInput);
                // Abrir a tela de criação de ingresso com o ID do filme
                new criarIngresso(idFilme).setVisible(true);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID do filme inválido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "ID do filme não fornecido.");
        }
    }

    private void itmListarIngressoActionPerformed(java.awt.event.ActionEvent evt) {
        new listarIngressos().setVisible(true);
    }

    private void itmEditarIngressoActionPerformed(java.awt.event.ActionEvent evt) {
        // Solicitar ao usuário que insira o ID do ingresso
        String idInput = JOptionPane.showInputDialog("Digite o ID do ingresso que deseja editar:");
        // Verificar se o usuário inseriu algum valor
        if (idInput != null && !idInput.isEmpty()) {
            try {
                int idIngresso = Integer.parseInt(idInput);
                new editarIngresso(idIngresso).setVisible(true);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID do ingresso inválido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "ID do ingresso não fornecido.");
        } 
    }

    private void itmExcluirIngressoActionPerformed(java.awt.event.ActionEvent evt) {
        // Solicitar ao usuário que insira o ID do ingresso
        int id;
        String idInput = JOptionPane.showInputDialog("Digite o ID do ingresso que deseja excluir:");
        if (idInput != null && !idInput.isEmpty()) {
            id = Integer.parseInt(idInput);
            try {
                new appData().excluirIngresso(id);
                // Avisar o usuário se os dados foram excluídos
                JOptionPane.showMessageDialog(null, "Ingresso excluído com sucesso");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar localizar o Driver JDBC");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na conexão com o Banco de dados:" + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "ID do ingresso não fornecido.");
        }
    }

    /* EVENTOS */
    private void itmCriarEventoActionPerformed(java.awt.event.ActionEvent evt) {
        new criarEvento().setVisible(true);
    }

    private void itmListarEventoActionPerformed(java.awt.event.ActionEvent evt) {
        new listarEventos().setVisible(true);
    }

    private void itmEditarEventoActionPerformed(java.awt.event.ActionEvent evt) {
        // Solicitar ao usuário que insira o ID do evento
        String idInput = JOptionPane.showInputDialog("Digite o ID do evento que deseja editar:");
        // Verificar se o usuário inseriu algum valor
        if (idInput != null && !idInput.isEmpty()) {
            try {
                int idEvento = Integer.parseInt(idInput);
                new editarEvento(idEvento).setVisible(true);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID do evento inválido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "ID do evento não fornecido.");
        }
    }

    private void itmExcluirEventoActionPerformed(java.awt.event.ActionEvent evt) {
        // Solicitar ao usuário que insira o ID do evento
        int id;
        String idInput = JOptionPane.showInputDialog("Digite o ID do evento que deseja excluir:");
        if (idInput != null && !idInput.isEmpty()) {
            id = Integer.parseInt(idInput);
            try {
                new appData().excluirEvento(id);
                // Avisar o usuário se os dados foram excluídos
                JOptionPane.showMessageDialog(null, "Evento excluído com sucesso");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar localizar o Driver JDBC");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na conexão com o Banco de dados:" + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "ID do evento não fornecido.");
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    private javax.swing.JMenuItem itmCriarAvaliacao;
    private javax.swing.JMenuItem itmCriarEvento;
    private javax.swing.JMenuItem itmCriarIngresso;
    private javax.swing.JMenuItem itmCriarProgramacao;
    private javax.swing.JMenuItem itmCriarSubmissao;
    private javax.swing.JMenuItem itmEditarAvaliacao;
    private javax.swing.JMenuItem itmEditarEvento;
    private javax.swing.JMenuItem itmEditarIngresso;
    private javax.swing.JMenuItem itmEditarProgramacao;
    private javax.swing.JMenuItem itmEditarSubmissao;
    private javax.swing.JMenuItem itmExcluirAvaliacao;
    private javax.swing.JMenuItem itmExcluirEvento;
    private javax.swing.JMenuItem itmExcluirIngresso;
    private javax.swing.JMenuItem itmExcluirProgramacao;
    private javax.swing.JMenuItem itmExcluirSubmissao;
    private javax.swing.JMenuItem itmListarAvaliacao;
    private javax.swing.JMenuItem itmListarEvento;
    private javax.swing.JMenuItem itmListarIngresso;
    private javax.swing.JMenuItem itmListarProgramacao;
    private javax.swing.JMenuItem itmListarSubmissao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mnuAvaliacoes;
    private javax.swing.JMenu mnuEventos;
    private javax.swing.JMenu mnuIngressos;
    private javax.swing.JMenu mnuProgramacoes;
    private javax.swing.JMenu mnuSubmissoes;
}
