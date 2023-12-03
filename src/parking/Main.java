package parking;

import parking.controller.*;
import javax.swing.*;
import java.util.logging.Logger;

public class Main extends JFrame {

    public Main() {
        initComponents();
        setTitle("Xulambs Parking");
    }

    private void initComponents() {

        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        addVeiculo = new JMenuItem();
        addCliente = new JMenuItem();
        exitMenuBtn = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jMenuBar1.add(jMenu1);
        jMenu1.setText("File");
        addVeiculo.setText("Adicionar veículo");
        exitMenuBtn.setText("Sair");
        addCliente.setText("Gerenciar vagas");
        jMenu1.add(addVeiculo);
        jMenu1.add(addCliente);
        jMenu1.add(exitMenuBtn);

        setJMenuBar(jMenuBar1);

        addVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirAddVeiculoView();
            }
        });
        addCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirListarVagaView();
            }
        });
        exitMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    private JMenuItem addCliente;
    private JMenuItem addVeiculo;
    private JMenuItem exitMenuBtn;
    private JMenu jMenu1;
    private JMenuBar jMenuBar1;
    private static Logger logger = Logger.getLogger(Main.class.getName());

    private AddVeiculoController abrirAddVeiculoView() {
        return new AddVeiculoController();
    }    

    private ListarVagaController abrirListarVagaView() {
        return new ListarVagaController();
    }
}

// private void addVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVeiculoActionPerformed
//     // add your handling code here:
// }//GEN-LAST:event_addVeiculoActionPerformed

// private void exitMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuBtnActionPerformed
//     this.dispose();// add your handling code here:
// }//GEN-LAST:event_exitMenuBtnActionPerformed

// private void addClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClienteActionPerformed
//     // add your handling code here:
// }//GEN-LAST:event_addClienteActionPerformed