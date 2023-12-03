package parking.view;

import javax.swing.*;
import java.util.logging.Logger;

public class MainView extends JFrame {

    public MainView() {
        initComponents();
        setTitle("Xulambs Parking - main");
    }

    public JMenuItem getMenuItemAddVeiculo() {
        return menuItemAddVeiculo;
    }

    public JMenuItem getMenuItemAddCliente() {
        return menuItemAddCliente;
    }

    public JMenuItem getButtonExitMenu() {
        return buttonExitMenu;
    }

    private void initComponents() {

        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        menuItemAddVeiculo = new JMenuItem();
        menuItemAddCliente = new JMenuItem();
        buttonExitMenu = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jMenuBar1.add(jMenu1);
        jMenu1.setText("File");
        menuItemAddVeiculo.setText("Adicionar veículo");
        buttonExitMenu.setText("Sair");
        menuItemAddCliente.setText("Gerenciar vagas");
        jMenu1.add(menuItemAddVeiculo);
        jMenu1.add(menuItemAddCliente);
        jMenu1.add(buttonExitMenu);

        setJMenuBar(jMenuBar1);

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
                new MainView().setVisible(true);
            }
        });
    }

    private JMenu jMenu1;
    private JMenuBar jMenuBar1;
    private JMenuItem menuItemAddVeiculo;
    private JMenuItem menuItemAddCliente;
    private JMenuItem buttonExitMenu;
    private static Logger logger = Logger.getLogger(MainView.class.getName());
}

// private void addVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVeiculoActionPerformed
//     // add your handling code here:
// }//GEN-LAST:event_addVeiculoActionPerformed

// private void buttonExitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitMenuActionPerformed
//     this.dispose();// add your handling code here:
// }//GEN-LAST:event_buttonExitMenuActionPerformed

// private void addClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClienteActionPerformed
//     // add your handling code here:
// }//GEN-LAST:event_addClienteActionPerformed