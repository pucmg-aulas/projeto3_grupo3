package parking.controller;

import parking.model.*;
import parking.view.AddEstacionamentoView;
import parking.archive.EstacionamentoArchive;

import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

public class AddEstacionamentoController {
    
    private static AddEstacionamentoController addEstacionamentoController;

    private AddEstacionamentoView telaView;
    private EstacionamentoArchive estacionamentoArchive;
    private HomeController homeController;

    public static AddEstacionamentoController getInstance() {
        if (addEstacionamentoController == null) {
            addEstacionamentoController = new AddEstacionamentoController();
        }
        return addEstacionamentoController;
    }

    private AddEstacionamentoController() {
        
        telaView = new AddEstacionamentoView();
        estacionamentoArchive = EstacionamentoArchive.getInstance();

        telaView.getButtonSalvar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarEstacionamento();
            }
        });

        telaView.getButtonCancelar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharTelaView();
            }
        });

        telaView.setVisible(true);
    }

    private void adicionarEstacionamento() {

        String estacionamentoNome = this.telaView.getTextNomeEstacionamento().getText();
        int quantidadeVagas = (int) this.telaView.getSpinnerQuantidadeVagas().getValue();
    
        List<Vaga> estacionamentoVagas = new ArrayList<Vaga>();
        for (int i = 0; i < quantidadeVagas; i++) {
            estacionamentoVagas.add(new Vaga(i, true));
        }

        Estacionamento novoEstacionamento = new Estacionamento(estacionamentoNome, estacionamentoVagas);
        // Estacionamento novoEstacionamento = new Estacionamento(estacionamentoNome);
        estacionamentoArchive.addEstacionamento(novoEstacionamento);
        JOptionPane.showMessageDialog(this.telaView, "Estacionamento criado com sucesso!");
        this.telaView.setVisible(false);

        homeController = HomeController.getInstance();
        homeController.carrergarComboBox();

        limparCampos();
    }

    private void limparCampos() {
        this.telaView.getTextNomeEstacionamento().setText("");
        this.telaView.getSpinnerQuantidadeVagas().setValue(1);
    }

    private void fecharTelaView() {
        this.telaView.setVisible(false);
    }
}