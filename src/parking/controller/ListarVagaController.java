package parking.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import parking.view.ListarVagaView;

public class ListarVagaController {

    private final ListarVagaView view;

    public ListarVagaController(ListarVagaView view) {
        this.view = view;
        initComponents();
    }

    private void initComponents() {
        // precisa adicionar os actions listeners aos butões (pesquisar como adicionar depois)
        view.getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarVaga();
            }
        });

        view.getBtnExcluir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirVaga();
            }
        });

        view.getBtnVoltar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltar();
            }
        });

        // caso precise, colocar mais inicializadores
    }

    private void editarVaga() {
        // é necessário colocar a lógica para edição da vaga
    }

    private void excluirVaga() {
        // semelhante ao de editar, precisa de adicionar a lógica para exclusão da vaga
    }

    private void voltar() {
        // acredito que isso sirva para voltar a outra janela ou fechar a janela atual
        view.setVisible(false);
    }



    public static void main(String[] args) {
        // metodo para testar o controlador caso precise
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListarVagaView view = new ListarVagaView();
                ListarVagaController controller = new ListarVagaController(view);
                view.setVisible(true);
            }
        });
    }
}