package parking.controller;

import parking.view.MainView;

public class MainController {

    private final MainView telaView;

    public MainController() {

        telaView = new MainView();

        telaView.getMenuItemAddVeiculo().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirAddVeiculoView();
            }
        });
        telaView.getMenuItemAddCliente().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirListarVagaView();
            }
        });
        telaView.getButtonExitMenu().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

        telaView.setVisible(true);
    }

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