package parking.view;

import javax.swing.*;
import java.util.logging.Logger;

public class HomeView extends JFrame {

    public HomeView() {
        initComponents();
        setTitle("Xulambs Parking");
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

        jMenuBar = new JMenuBar();
        menuFile = new JMenu();
        menuItemAddVeiculo = new JMenuItem();
        menuItemAddCliente = new JMenuItem();
        buttonExitMenu = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jMenuBar.add(menuFile);
        menuFile.setText("File");
        menuItemAddVeiculo.setText("Adicionar veículo");
        buttonExitMenu.setText("Sair");
        menuItemAddCliente.setText("Gerenciar vagas");
        menuFile.add(menuItemAddVeiculo);
        menuFile.add(menuItemAddCliente);
        menuFile.add(buttonExitMenu);

        setJMenuBar(jMenuBar);

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
                new HomeView().setVisible(true);
            }
        });
    }

    private JMenu menuFile;
    private JMenuBar jMenuBar;
    private JMenuItem menuItemAddVeiculo;
    private JMenuItem menuItemAddCliente;
    private JMenuItem buttonExitMenu;
    private static Logger logger = Logger.getLogger(HomeView.class.getName());
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