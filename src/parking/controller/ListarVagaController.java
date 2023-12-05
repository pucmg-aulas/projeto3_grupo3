package parking.controller;

import java.util.Iterator;
import javax.swing.JOptionPane;
import parking.view.ListarVagaView;
import parking.view.AddVeiculoView;
import javax.swing.table.DefaultTableModel;
import parking.archive.VeiculoArchive;
import parking.model.Veiculo;

public class ListarVagaController {

    private final ListarVagaView telaView;
    private VeiculoArchive veiculoArchive;

    private static ListarVagaController ListarVagaController;

    public static ListarVagaController getInstance() {
        if (ListarVagaController == null) {
            ListarVagaController = new ListarVagaController();
        }
        
        return ListarVagaController;
    }

    private ListarVagaController() {

        telaView = new ListarVagaView();
        veiculoArchive = VeiculoArchive.getInstance();

        carregarTabela();

        telaView.getButtonVoltar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telaView.setVisible(false);
            }
        });

        telaView.getButtonEditar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarVeiculo();
            }
        });

        telaView.getButtonExcluir().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirVeiculo();
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
            Veiculo veiculo = it.next();
            String veiculoString = veiculo.toString();
            String linha[] = veiculoString.split("%");

            String veiculoPlaca = linha[0];
            String veiculoVaga = linha[1];

            tm.addRow(new Object[]{"", "", veiculoPlaca, veiculoVaga});
        }
        this.telaView.getTableVagas().setModel(tm);
    }

    private void excluirVeiculo () {

        int linha = telaView.getTableVagas().getSelectedRow();

        if (linha < -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha");
            return;
        }

        String placa = (String) telaView.getTableVagas().getValueAt(linha, 2);
        Veiculo veiculo = veiculoArchive.buscarVeiculoPorPlaca(placa);

        int op = JOptionPane.showConfirmDialog(telaView, "Deseja excluir " + placa + "?");

        if (veiculo != null && op == JOptionPane.YES_OPTION) {
            veiculoArchive.removeVeiculo(veiculo);
            JOptionPane.showMessageDialog(telaView, placa + " Excluído com Sucesso!");
            carregarTabela();
        } else {
            JOptionPane.showMessageDialog(null, "Veículo não encontrado");
        }
    }

    private void editarVeiculo() {
        // Vou abrir a view de adicionar veículo com o titulo de editar
        AddVeiculoView addVeiculoView = new AddVeiculoView();
        addVeiculoView.setTitle("Editar Veículo");

        int linha = telaView.getTableVagas().getSelectedRow();
        String placa = (String) telaView.getTableVagas().getValueAt(linha, 2);
        String vaga = (String) telaView.getTableVagas().getValueAt(linha, 3);

        addVeiculoView.getTextPlacaVeiculo().setText(placa);
        addVeiculoView.getTextVagaVeiculo().setText(vaga);

        Veiculo veiculoAntigo = veiculoArchive.buscarVeiculoPorPlaca(placa);

        addVeiculoView.getButtonSalvar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String veiculoPlaca = addVeiculoView.getTextPlacaVeiculo().getText();
                String veiculoVaga = addVeiculoView.getTextVagaVeiculo().getText();

                veiculoArchive.editarVeiculo(new Veiculo(veiculoPlaca, veiculoVaga), veiculoAntigo);

                JOptionPane.showMessageDialog(addVeiculoView, "Veículo editado com sucesso!");

                addVeiculoView.setVisible(false);
                carregarTabela();
            }
        });

        addVeiculoView.setVisible(true);
    }
}