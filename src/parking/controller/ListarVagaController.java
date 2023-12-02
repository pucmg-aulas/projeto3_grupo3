package parking.controller;

import parking.view.ListarVagaView;

public class ListarVagaController {

    private final ListarVagaView telaView;

    public ListarVagaController() {

        telaView = new ListarVagaView();

        telaView.getBtnEditar().setText("Editar");
        telaView.getBtnExcluir().setText("Excluir");
        telaView.getBtnVoltar().setText("Voltar");

        telaView.setVisible(true);
    }
}