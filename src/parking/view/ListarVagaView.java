package parking.view;

import javax.swing.*;
import java.util.logging.Logger;

public class ListarVagaView extends JFrame {

    public ListarVagaView() {
        initComponents();
        setTitle("Xulambs Parking - Gerenciar vagas");
    }
    public JButton getButtonEditar() {
        return buttonEditar;
    }

    public JButton getButtonExcluir() {
        return buttonExcluir;
    }

    public JButton getButtonVoltar() {
        return buttonVoltar;
    }

    public JTable getTableVagas() {
        return tableVagas;
    }

    public void setTableVagas(JTable tableVagas) {
        this.tableVagas = tableVagas;
    }

    private void initComponents() {

        buttonVoltar = new JButton();
        buttonEditar = new JButton();
        buttonExcluir = new JButton();
        jScrollPane1 = new JScrollPane();
        tableVagas = new JTable();

        buttonEditar.setText("Editar");
        buttonExcluir.setText("Excluir");
        buttonVoltar.setText("Voltar");

        tableVagas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"Cliente", "Id Cliente", "Vaga", "Placa"}
        ));

        jScrollPane1.setViewportView(tableVagas);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonExcluir)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonEditar)
                        .addGap(4, 4, 4)
                        .addComponent(buttonVoltar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonExcluir)
                    .addComponent(buttonEditar)
                    .addComponent(buttonVoltar))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                new ListarVagaView().setVisible(true);
            }
        });
    }

    private JButton buttonEditar;
    private JButton buttonExcluir;
    private JButton buttonVoltar;
    private JScrollPane jScrollPane1;
    private JTable tableVagas;
    private static Logger logger = Logger.getLogger(ListarVagaView.class.getName());
}