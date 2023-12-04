package parking.view;

import javax.swing.*;
import java.util.logging.Logger;

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

    private static Logger logger = Logger.getLogger(AddVeiculoView.class.getName());

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
}