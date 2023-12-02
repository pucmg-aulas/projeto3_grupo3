package parking.controller;

import parking.view.AddVeiculoView;

public class AddVeiculoController {

    private AddVeiculoView telaView;

    public AddVeiculoController() {
        
        telaView = new AddVeiculoView();

        telaView.getTextPlacaVeiculo().setText("Placa"); // Passa a placa do carro
        telaView.getTextVagaVeiculo().setText("Vaga"); // Passa o id da vaga

        telaView.getBtnSalvar().setText("Salvar");
        telaView.getBtnCancelar().setText("Cancelar");

        telaView.getBtnCancelar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telaView.setVisible(false);
            }
        });

        telaView.getBtnSalvar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarVeiculo();
            }
        });


        telaView.setVisible(true);
    }

    private void adicionarVeiculo() {
        String veiculoPlaca = this.telaView.getTextPlacaVeiculo().getText();
        int numeroVaga = Integer.parseInt(this.telaView.getTextVagaVeiculo().getText());
    }
}