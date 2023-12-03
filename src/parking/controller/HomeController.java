package parking.controller;

import parking.view.HomeView;

public class HomeController {

    private final HomeView telaView;

    public HomeController() {

        telaView = new HomeView();

        telaView.getMenuItemAddVeiculo().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirAddVeiculoView();
            }
        });
        telaView.getMenuItemAddCliente().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirListarVagaView();
            }
        });
        telaView.getButtonExitMenu().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

        telaView.setVisible(true);
    }

    private AddVeiculoController abrirAddVeiculoView() {
        return new AddVeiculoController();
    }    

    private ListarVagaController abrirListarVagaView() {
        return new ListarVagaController();
    }
}