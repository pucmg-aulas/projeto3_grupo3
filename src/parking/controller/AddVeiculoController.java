package parking.controller;

import parking.archive.ClienteArchive;
import parking.model.Cliente;
import parking.model.Estacionamento;
import parking.model.Vaga;
import parking.view.AddVeiculoView;

import javax.swing.*;

import parking.archive.VeiculoArchive;
import parking.model.Veiculo;

import java.util.List;
import java.util.Objects;

public class AddVeiculoController {

    private static AddVeiculoController addVeiculoController;

    private AddVeiculoView telaView;
    private VeiculoArchive veiculoArchive;
    private ClienteArchive clienteArchive;
    private HomeController homeController;

    public static AddVeiculoController getInstance() {
        if (addVeiculoController == null) {
            addVeiculoController = new AddVeiculoController();
        }
        return addVeiculoController;
    }

    private AddVeiculoController() {

        telaView = new AddVeiculoView();
        veiculoArchive = VeiculoArchive.getInstance();
        clienteArchive = ClienteArchive.getInstance();

        List<String> nomesClientes = clienteArchive.getClientes()
                .stream()
                .map(cliente -> "%s: \"%s\"".formatted(cliente.getId(), cliente.getNome()))
                .toList();

        for (String nome : nomesClientes) {
            telaView.getClienteComboBox().addItem(nome);
        }

        telaView.getButtonSalvar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarVeiculo();
            }
        });

        telaView.getButtonCancelar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharTelaView();
            }
        });

    }

    private void adicionarVeiculo() {

        String veiculoPlaca = this.telaView.getTextPlacaVeiculo().getText();
        String veiculoVaga = this.telaView.getTextVagaVeiculo().getText();

        if (veiculoPlaca.length() < 7) {
            JOptionPane.showMessageDialog(this.telaView, "Placa do veiculo deve ter pelo menos 7 caracteres!");
            return;
        }

        if (veiculoArchive.buscarVeiculoPorPlaca(veiculoPlaca) != null) {
            JOptionPane.showMessageDialog(this.telaView, "Placa do veiculo já existe!");
            return;
        }

        Veiculo novoVeiculo = new Veiculo(veiculoPlaca, veiculoVaga);
        Veiculo veiculoAntigo = veiculoArchive.buscarVeiculoPorPlaca(veiculoPlaca);
        veiculoArchive.editarVeiculo(novoVeiculo, veiculoAntigo);

        veiculoArchive.addVeiculo(novoVeiculo);
        JOptionPane.showMessageDialog(this.telaView, "Veiculo foi criado com sucesso!");
        this.telaView.setVisible(false);

        homeController = HomeController.getInstance();
        homeController.carregarComboBox();

        limparCampos();
    }

    private void limparCampos() {
        this.telaView.getTextPlacaVeiculo().setText("");
        this.telaView.getTextVagaVeiculo().setText("");
    }

    public void abrirTelaView() {
        this.telaView.setVisible(true);
    }

    public void fecharTelaView() {
        this.telaView.setVisible(false);
    }
}
