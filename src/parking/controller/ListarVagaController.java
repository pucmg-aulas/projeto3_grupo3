package parking.controller;

import parking.view.ListarVagaView;

public class ListarVagaController {

    private final ListarVagaView telaView;

    public ListarVagaController() {

        telaView = new ListarVagaView();

        telaView.getBtnVoltar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telaView.setVisible(false);
            }
        });

        telaView.setVisible(true);
    }
}