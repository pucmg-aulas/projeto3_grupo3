package parking.controller;

import parking.archive.ClienteArchive;
import parking.model.Cliente;
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

        for(String nome : nomesClientes){
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
        String numeroVaga = this.telaView.getTextVagaVeiculo().getText();

        Veiculo novoVeiculo = new Veiculo(veiculoPlaca, numeroVaga);

        String clienteId = Objects.requireNonNull(this.telaView.getClienteComboBox().getSelectedItem()).toString().split(":", 1)[0];

        ClienteArchive clienteArchive = ClienteArchive.getInstance();
        Cliente clienteAntigo = clienteArchive.getClientes().stream().filter(clienteElemento -> clienteElemento.getId().equals(clienteId)).findFirst().orElse(null);

        veiculoArchive.addVeiculo(novoVeiculo);
        if(clienteAntigo != null){
            Cliente clienteNovo = new Cliente(clienteAntigo.getId(), clienteAntigo.getNome());
            clienteNovo.addVeiculo(novoVeiculo);
            clienteArchive.editarClientes(clienteAntigo, clienteNovo);
        }
        JOptionPane.showMessageDialog(this.telaView, "VeÃ­culo salvo com sucesso!");
        this.telaView.setVisible(false);

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
