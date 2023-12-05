package parking.controller;

import java.util.Iterator;
import javax.swing.JOptionPane;
import parking.view.ListarEstacionamentoView;
import javax.swing.table.DefaultTableModel;
import parking.archive.EstacionamentoArchive;
import parking.model.Estacionamento;

public class ListarEstacionamentoController {

    private final ListarEstacionamentoView telaView;
    private EstacionamentoArchive estacionamentoArchive;

    private static ListarEstacionamentoController ListarEstacionamentoController;

    public static ListarEstacionamentoController getInstance() {
        if (ListarEstacionamentoController == null) {
            ListarEstacionamentoController = new ListarEstacionamentoController();
        }
        
        return ListarEstacionamentoController;
    }

    private ListarEstacionamentoController() {

        telaView = new ListarEstacionamentoView();
        estacionamentoArchive = EstacionamentoArchive.getInstance();

        carregarTabela();

        telaView.getButtonVoltar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telaView.setVisible(false);
            }
        });

        // telaView.getButtonEditar().addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         editarVeiculo();
        //     }
        // });

        telaView.getButtonExcluir().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirVeiculo();
            }
        });

        telaView.setVisible(true);
    }

    private void carregarTabela() {
        Object colunas[] = {"Nome", "Vagas"};
        DefaultTableModel tm = new DefaultTableModel(colunas, 0);
        tm.setNumRows(0);

        Iterator<Estacionamento> it = estacionamentoArchive.getEstacionamentos().iterator();
        while (it.hasNext()) {
            Estacionamento estacionamento = it.next();
            tm.addRow(new Object[]{estacionamento.getNome(), estacionamento.getVagas().size()});
        }
        this.telaView.getTableEstacionamentos().setModel(tm);
    }

    private void excluirVeiculo () {

        int linha = telaView.getTableEstacionamentos().getSelectedRow();

        if (linha < -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha");
            return;
        }

        // String placa = (String) telaView.getTableEstacionamentos().getValueAt(linha, 2);
        // Veiculo veiculo = veiculoArchive.buscarVeiculoPorPlaca(placa);

        // int op = JOptionPane.showConfirmDialog(telaView, "Deseja excluir " + placa + "?");

        // if (veiculo != null && op == JOptionPane.YES_OPTION) {
        //     veiculoArchive.removeVeiculo(veiculo);
        //     JOptionPane.showMessageDialog(telaView, placa + " Excluído com Sucesso!");
        //     carregarTabela();
        // } else {
        //     JOptionPane.showMessageDialog(null, "Veículo não encontrado");
        // }
    }

    // private void editarVeiculo() {
    //     // Vou abrir a view de adicionar veículo com o titulo de editar
    //     AddVeiculoView addVeiculoView = new AddVeiculoView();
    //     addVeiculoView.setTitle("Editar Veículo");

    //     int linha = telaView.getTableEstacionamentos().getSelectedRow();
    //     String placa = (String) telaView.getTableEstacionamentos().getValueAt(linha, 2);
    //     String Estacionamento = (String) telaView.getTableEstacionamentos().getValueAt(linha, 3);

    //     addVeiculoView.getTextPlacaVeiculo().setText(placa);
    //     addVeiculoView.getTextEstacionamentoVeiculo().setText(Estacionamento);

    //     Veiculo veiculoAntigo = veiculoArchive.buscarVeiculoPorPlaca(placa);

    //     addVeiculoView.getButtonSalvar().addActionListener(new java.awt.event.ActionListener() {
    //         public void actionPerformed(java.awt.event.ActionEvent evt) {
    //             String veiculoPlaca = addVeiculoView.getTextPlacaVeiculo().getText();
    //             String veiculoEstacionamento = addVeiculoView.getTextEstacionamentoVeiculo().getText();

    //             veiculoArchive.editarVeiculo(new Veiculo(veiculoPlaca, veiculoEstacionamento), veiculoAntigo);

    //             JOptionPane.showMessageDialog(addVeiculoView, "Veículo editado com sucesso!");

    //             addVeiculoView.setVisible(false);
    //             carregarTabela();
    //         }
    //     });

    //     addVeiculoView.setVisible(true);
    // }
}