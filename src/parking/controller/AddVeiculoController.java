package parking.controller;

import parking.view.AddVeiculoView;

public class AddVeiculoController {

    private AddVeiculoView telaView;

    public AddVeiculoController() {
        
        telaView = new AddVeiculoView();

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