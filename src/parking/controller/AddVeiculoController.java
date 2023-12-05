package parking.controller;

import parking.view.AddVeiculoView;
import javax.swing.JOptionPane;
import parking.archive.VeiculoArchive;
import parking.model.Veiculo;

public class AddVeiculoController {

    private AddVeiculoView telaView;
    private VeiculoArchive veiculoArchive;

    public AddVeiculoController() {
        
        telaView = new AddVeiculoView();
        veiculoArchive = VeiculoArchive.getInstance();

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

        telaView.setVisible(true);
    }

    private void adicionarVeiculo() {

        String veiculoPlaca = this.telaView.getTextPlacaVeiculo().getText();
        String numeroVaga = this.telaView.getTextVagaVeiculo().getText();

        Veiculo novoVeiculo = new Veiculo(veiculoPlaca, numeroVaga);

        veiculoArchive.addVeiculo(novoVeiculo);
        JOptionPane.showMessageDialog(this.telaView, "Veículo salvo com sucesso!");
        this.telaView.setVisible(false);

        limparCampos();
    }

    private void limparCampos() {
        this.telaView.getTextPlacaVeiculo().setText("");
        this.telaView.getTextVagaVeiculo().setText("");
    }

    private void fecharTelaView() {
        this.telaView.setVisible(false);
    }
}