package parking.view;

import javax.swing.*;

public class AddClienteView extends JFrame {

    private JPanel jPanel = new JPanel();
    private JToggleButton buttonCancelar = new JToggleButton();
    private JToggleButton buttonSalvar = new JToggleButton();
    private JLabel nomeClienteRotulo = new JLabel();
    private JLabel idClienteRotulo = new JLabel();
    private JTextField textNomeCliente = new JTextField();
    private JTextField textIdCliente = new JTextField();

    public JTextField getTextNomeCliente() {
        return textNomeCliente;
    }

    public JTextField getTextIdCliente() {
        return textIdCliente;
    }

    public AddClienteView() {
        initComponents();
        setTitle("Xulambs Parking - Adicionar cliente");
        setLocationRelativeTo(null);
    }

    public JToggleButton getButtonCancelar() {
        return buttonCancelar;
    }

    public JToggleButton getButtonSalvar() {
        return buttonSalvar;
    }

    private void initComponents() {

        idClienteRotulo.setText("Id Cliente");
        nomeClienteRotulo.setText("Nome Cliente");
        buttonSalvar.setText("Salvar");
        buttonCancelar.setText("Cancelar");

        GroupLayout jPanelLayout = new GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(textIdCliente)
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(idClienteRotulo)
                                                        .addComponent(nomeClienteRotulo))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(textNomeCliente)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                                .addGap(0, 112, Short.MAX_VALUE)
                                                .addComponent(buttonCancelar)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buttonSalvar)))
                                .addContainerGap())
        );
        jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(idClienteRotulo)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textIdCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeClienteRotulo)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textNomeCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonSalvar)
                                        .addComponent(buttonCancelar))
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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