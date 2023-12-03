package parking.view;

import javax.swing.*;
import java.util.logging.Logger;

public class AddVeiculoView extends JFrame {

    public AddVeiculoView() {
        initComponents();
        setTitle("Xulambs Parking - Adicionar veículo");
    }

    public JToggleButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JToggleButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JToggleButton getBtnSalvar() {
        return btnSalvar;
    }

    public void setBtnSalvar(JToggleButton btnSalvar) {
        this.btnSalvar = btnSalvar;
    }

    public JTextField getTextVagaVeiculo() {
        return txtVagaVeiculo;
    }

    public void setTextVagaVeiculo(JTextField txtVagaVeiculo) {
        this.txtVagaVeiculo = txtVagaVeiculo;
    }

    public JTextField getTextPlacaVeiculo() {
        return txtPlacaVeiculo;
    }

    public void setTextPlacaVeiculo(JTextField txtPlacaVeiculo) {
        this.txtPlacaVeiculo = txtPlacaVeiculo;
    }

    private void initComponents() {

        jPanel3 = new JPanel();
        carroPlacaRotulo = new JLabel();
        txtPlacaVeiculo = new JTextField();
        numeroVagaRotulo = new JLabel();
        txtVagaVeiculo = new JTextField();
        btnSalvar = new JToggleButton();
        btnCancelar = new JToggleButton();

        carroPlacaRotulo.setText("Placa");
        numeroVagaRotulo.setText("Vaga");
        btnSalvar.setText("Salvar");
        btnCancelar.setText("Cancelar");

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(txtPlacaVeiculo)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(carroPlacaRotulo)
                            .addComponent(numeroVagaRotulo))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtVagaVeiculo)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 112, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(carroPlacaRotulo)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPlacaVeiculo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numeroVagaRotulo)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtVagaVeiculo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
                new AddVeiculoView().setVisible(true);
            }
        });
    }

    private JToggleButton btnCancelar;
    private JToggleButton btnSalvar;
    private JLabel carroPlacaRotulo;
    private JLabel numeroVagaRotulo;
    private JPanel jPanel3;
    private JTextField txtPlacaVeiculo;
    private JTextField txtVagaVeiculo;
    private static Logger logger = Logger.getLogger(AddVeiculoView.class.getName());
}