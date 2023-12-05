package parking.controller;

import parking.view.HomeView;
import parking.archive.EstacionamentoArchive;

import parking.model.Estacionamento;
public class HomeController {

    private static HomeController homeController;
    private final HomeView telaView;

    private final EstacionamentoArchive estacionamentoArchive;

    public static HomeController getInstance() {
        if (homeController == null) {
            homeController = new HomeController();
        }
        return homeController;
    }
    
    private HomeController() {
      
        telaView = new HomeView();
        estacionamentoArchive = EstacionamentoArchive.getInstance();

        carregarComboBox();

        if (estacionamentoArchive.getEstacionamentos().size() == 0) {
            telaView.getMenuItemAddVaga().setEnabled(false);
            telaView.getMenuItemAddVeiculo().setEnabled(false);
            telaView.getMenuItemAddCliente().setEnabled(false);
            telaView.getMenuItemGerenciarVagas().setEnabled(false);
        }

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
        telaView.getMenuItemAddCliente().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirAbrirClienteView();
            }
        });
        telaView.getMenuItemGerenciarVagas().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirListarVagaView();
            }
        });

        telaView.getMenuItemGerenciarClientes().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirListarClienteView();
            }
        });

        telaView.getMenuItemGerenciarEstacionamentos().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirListarEstacionamentoView();
            }
        });

        telaView.getButtonExitMenu().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

        telaView.setVisible(true);
    }

    private void abrirAbrirClienteView() {
        AddClienteController.getInstance();
    }

    private void abrirAddEstacionamentoView() {
        AddEstacionamentoController.getInstance();
    }

    // private AddVagaController abrirAddVagaView() {
    //     return new AddVagaController();
    // }

    private void abrirAddVeiculoView() {
        AddVeiculoController.getInstance();
    } 

    private void abrirListarVagaView() {
        ListarVagaController.getInstance();
    }

    private void abrirListarClienteView() {
        ListarClienteController.getInstance();
    }

    private void abrirListarEstacionamentoView() {
        ListarEstacionamentoController.getInstance();
    }

    public void carregarComboBox() {
        telaView.getEstacionamentoComboBox().removeAllItems();
        for (Estacionamento estacionamento : estacionamentoArchive.getEstacionamentos()) {
            telaView.getEstacionamentoComboBox().addItem(estacionamento.getNome() + " - " + estacionamento.getVagas().size() + " vagas");
        }
    }
}
