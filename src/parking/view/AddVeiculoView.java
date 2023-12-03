package parking.view;

import javax.swing.*;
import java.util.logging.Logger;

public class AddVeiculoView extends JFrame {

    public AddVeiculoView() {
        initComponents();
        setTitle("Xulambs Parking - Adicionar veículo");
    }

    public JToggleButton getButtonCancelar() {
        return buttonCancelar;
    }

    public void setButtonCancelar(JToggleButton buttonCancelar) {
        this.buttonCancelar = buttonCancelar;
    }

    public JToggleButton getButtonSalvar() {
        return buttonSalvar;
    }

    public void setButtonSalvar(JToggleButton buttonSalvar) {
        this.buttonSalvar = buttonSalvar;
    }

    public JTextField getTextVagaVeiculo() {
        return textVagaVeiculo;
    }

    public void setTextVagaVeiculo(JTextField textVagaVeiculo) {
        this.textVagaVeiculo = textVagaVeiculo;
    }

    public JTextField getTextPlacaVeiculo() {
        return textPlacaVeiculo;
    }

    public void setTextPlacaVeiculo(JTextField textPlacaVeiculo) {
        this.textPlacaVeiculo = textPlacaVeiculo;
    }

    private void initComponents() {

        jPanel3 = new JPanel();
        carroPlacaRotulo = new JLabel();
        textPlacaVeiculo = new JTextField();
        numeroVagaRotulo = new JLabel();
        textVagaVeiculo = new JTextField();
        buttonSalvar = new JToggleButton();
        buttonCancelar = new JToggleButton();

        carroPlacaRotulo.setText("Placa");
        numeroVagaRotulo.setText("Vaga");
        buttonSalvar.setText("Salvar");
        buttonCancelar.setText("Cancelar");

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(textPlacaVeiculo)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(carroPlacaRotulo)
                            .addComponent(numeroVagaRotulo))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(textVagaVeiculo)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 112, Short.MAX_VALUE)
                        .addComponent(buttonCancelar)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSalvar)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(carroPlacaRotulo)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textPlacaVeiculo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numeroVagaRotulo)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textVagaVeiculo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSalvar)
                    .addComponent(buttonCancelar))
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

    private JToggleButton buttonCancelar;
    private JToggleButton buttonSalvar;
    private JLabel carroPlacaRotulo;
    private JLabel numeroVagaRotulo;
    private JPanel jPanel3;
    private JTextField textPlacaVeiculo;
    private JTextField textVagaVeiculo;
    private static Logger logger = Logger.getLogger(AddVeiculoView.class.getName());
}