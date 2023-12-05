package parking.controller;

import java.util.List;
import java.util.Iterator;
import javax.swing.JOptionPane;

import parking.view.AddEstacionamentoView;
import parking.view.ListarEstacionamentoView;
import javax.swing.table.DefaultTableModel;
import parking.archive.EstacionamentoArchive;
import parking.model.Estacionamento;
import parking.model.Vaga;

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

        telaView.getButtonEditar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarEstacionamento();
            }
        });

        telaView.getButtonExcluir().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirEstacionamento();
            }
        });
    }

    public void abrirTelaView() {
        this.telaView.setVisible(true);
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

    private void excluirEstacionamento () {

        int linha = telaView.getTableEstacionamentos().getSelectedRow();

        if (linha < -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha");
            return;
        }

        String nome = (String) telaView.getTableEstacionamentos().getValueAt(linha, 0);
        Estacionamento estacionamento = estacionamentoArchive.buscarEstacionamentoPorNome(nome);

        int op = JOptionPane.showConfirmDialog(telaView, "Deseja excluir estacionamento " + estacionamento.getNome() + "?");

        if (estacionamento != null && op == JOptionPane.YES_OPTION) {
            estacionamentoArchive.removeEstacionamento(estacionamento);
            JOptionPane.showMessageDialog(telaView, nome + " Excluído com Sucesso!");
            carregarTabela();
        } else {
            if (op == JOptionPane.NO_OPTION || op == JOptionPane.CANCEL_OPTION) 
                JOptionPane.showMessageDialog(null, "Operação cancelada");
            else
                JOptionPane.showMessageDialog(null, "Estacionamento não encontrado");
        }
    }

    private void editarEstacionamento() {

        AddEstacionamentoView addEstacionamentoView = new AddEstacionamentoView();
        addEstacionamentoView.setTitle("Editar Estacionamento");
        addEstacionamentoView.setVisible(true);

        int linha = telaView.getTableEstacionamentos().getSelectedRow();
        String nome = (String) telaView.getTableEstacionamentos().getValueAt(linha, 0);
        int numeroVagas = (int) telaView.getTableEstacionamentos().getValueAt(linha, 1);

        addEstacionamentoView.getTextFieldNome().setText(nome);
        addEstacionamentoView.getSpinnerQuantidadeVagas().setValue(numeroVagas);

        Estacionamento estacionamento = estacionamentoArchive.buscarEstacionamentoPorNome(nome);

        addEstacionamentoView.getButtonSalvar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String nome = addEstacionamentoView.getTextFieldNome().getText();
                int numeroVagas = (int) addEstacionamentoView.getSpinnerQuantidadeVagas().getValue();

                List<Vaga> vagas = estacionamento.getVagas();

                if (numeroVagas > vagas.size()) {
                    for (int i = vagas.size(); i < numeroVagas; i++) {
                        Vaga vaga = new Vaga(i, true);
                        vagas.add(vaga);
                    }
                } else if (numeroVagas < vagas.size()) {
                    for (int i = vagas.size(); i > numeroVagas; i--) {
                        vagas.remove(i);
                    }
                }

                Estacionamento estacionamentoNovo = new Estacionamento(nome, vagas);
                estacionamentoArchive.editarEstacionamento(estacionamentoNovo, estacionamento);
                JOptionPane.showMessageDialog(null, "Estacionamento editado com sucesso!");
                addEstacionamentoView.setVisible(false);
                carregarTabela();
            }
        });
    }
}