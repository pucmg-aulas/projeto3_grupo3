package parking.controller;

import java.util.Iterator;
import javax.swing.JOptionPane;
import parking.view.ListarVagaView;
import javax.swing.table.DefaultTableModel;
import parking.archive.VeiculoArchive;
import parking.model.Veiculo;

public class ListarVagaController {

    private final ListarVagaView telaView;
    private VeiculoArchive veiculoArchive;

    public ListarVagaController() {

        telaView = new ListarVagaView();
        veiculoArchive = VeiculoArchive.getInstance();

        carregarTabela();

        telaView.getBtnVoltar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telaView.setVisible(false);
            }
        });

        telaView.getBtnEditar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarVagas();
            }
        });

        telaView.setVisible(true);
    }

    private void carregarTabela() {
        Object colunas[] = {"Cliente", "Id Cliente", "Vaga", "Placa"};
        DefaultTableModel tm = new DefaultTableModel(colunas, 0);

        tm.setNumRows(0);
        Iterator<Veiculo> it = veiculoArchive.getVeiculos().iterator();
        while (it.hasNext()) {
            Veiculo c = it.next();
            String veiculoString = c.toString();
            String linha[] = veiculoString.split("%");
            tm.addRow(new Object[]{"", "", linha[0], linha[1]});
        }
        this.telaView.getTbVagas().setModel(tm);
    }

    private void listarVagas() {
        System.out.println("Listando vagas...");
    }
}