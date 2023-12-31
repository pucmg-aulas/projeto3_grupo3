package parking.view;

import javax.swing.*;

public class AddVeiculoView extends JFrame {

    private JToggleButton buttonCancelar = new JToggleButton();
    private JToggleButton buttonSalvar = new JToggleButton();
    private JLabel carroPlacaRotulo = new JLabel();
    private JLabel numeroVagaRotulo = new JLabel();
    private JLabel clienteRotulo = new JLabel();
    private JComboBox<String> clienteComboBox = new JComboBox<>();
    private JPanel jPanel3 = new JPanel();
    private JTextField textPlacaVeiculo = new JTextField();
    private JTextField textVagaVeiculo = new JTextField();

    public AddVeiculoView() {
        initComponents();
        setTitle("Xulambs Parking - Adicionar veÃ­culo");
        setLocationRelativeTo(null);
    }

    public JComboBox<String> getClienteComboBox() {
        return clienteComboBox;
    }

    public void setClienteComboBox(JComboBox<String> clienteComboBox) {
        this.clienteComboBox = clienteComboBox;
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

        carroPlacaRotulo.setText("Placa");
        numeroVagaRotulo.setText("Vaga");
        clienteRotulo.setText("Cliente");
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
                            .addComponent(numeroVagaRotulo)
                            .addComponent(clienteRotulo))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(textVagaVeiculo)
                    .addComponent(clienteComboBox)
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
                .addComponent(clienteRotulo)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clienteComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AddVeiculoView().setVisible(true);
            }
        });
    }
}
