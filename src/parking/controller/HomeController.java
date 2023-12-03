package parking.controller;

import parking.view.HomeView;

public class HomeController {

    private final HomeView telaView;

    public HomeController() {

        telaView = new HomeView();

        telaView.getMenuItemAddEstacionamento().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirAddEstacionamentoView();
            }
        });
        // telaView.getMenuItemAddVaga().addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         abrirAddVagaView();
        //     }
        // });
        telaView.getMenuItemAddVeiculo().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirAddVeiculoView();
            }
        });
        telaView.getMenuItemGerenciarVagas().addActionListener(new java.awt.event.ActionListener() {
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

    private AddEstacionamentoController abrirAddEstacionamentoView() {
        return new AddEstacionamentoController();
    }

    // private AddVagaController abrirAddVagaView() {
    //     return new AddVagaController();
    // }

    private AddVeiculoController abrirAddVeiculoView() {
        return new AddVeiculoController();
    } 

    private ListarVagaController abrirListarVagaView() {
        return new ListarVagaController();
    }
}