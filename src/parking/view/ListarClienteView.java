package parking.view;

import javax.swing.*;

public class ListarClienteView extends JFrame {

    private JButton buttonExcluir = new JButton();
    private JButton buttonEditar  = new JButton();
    private JButton buttonVoltar  = new JButton();
    private JScrollPane jScrollPane = new JScrollPane();
    private JTable tableClientes = new JTable();

    public ListarClienteView() {
        initComponents();
        setTitle("Xulambs Parking - Gerenciar clientes");
        setLocationRelativeTo(null);
    }

    public JButton getButtonExcluir() {
        return buttonExcluir;
    }

    public JButton getButtonEditar() {
        return buttonEditar;
    }

    public JButton getButtonVoltar() {
        return buttonVoltar;
    }

    public JTable getTableClientes() {
        return tableClientes;
    }

    public void setTableClientes(JTable tableClientes) {
        this.tableClientes = tableClientes;
    }

    private void initComponents() {

        buttonEditar.setText("Editar");
        buttonExcluir.setText("Excluir");
        buttonVoltar.setText("Voltar");

        jScrollPane.setViewportView(tableClientes);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonExcluir)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonEditar)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonVoltar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonVoltar)
                    .addComponent(buttonEditar)
                    .addComponent(buttonExcluir))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListarClienteView().setVisible(true);
            }
        });
    }
}