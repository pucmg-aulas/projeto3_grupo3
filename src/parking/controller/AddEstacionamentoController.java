package parking.controller;

import parking.view.AddEstacionamentoView;
import parking.model.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class AddEstacionamentoController {
    
    private AddEstacionamentoView telaView;

    public AddEstacionamentoController() {
        
        telaView = new AddEstacionamentoView();

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

    List<Vaga> vagas = new ArrayList<>();
    Estacionamento estacionamento = null;

    for (int i = 0; i < quantidadeVagas; i++) {
        estacionamento = new Estacionamento(estacionamentoNome, new ArrayList<>());
        Vaga vaga = new Vaga(i);
        estacionamento.getVagas().add(vaga);
        vagas.add(vaga);
    }

    Estacionamento novoEstacionamento = new Estacionamento(estacionamentoNome, vagas);

    Estacionamento.addEstacionamento(novoEstacionamento);

    JOptionPane.showMessageDialog(this.telaView, "Estacionamento salvo com sucesso!");

    limparCampos();
}

    // private void limparCampos() {
    //     this.telaView.getTextNomeEstacionamento().setText("");
    //     this.telaView.getSpinnerQuantidadeVagas().setValue(1);
    // }

    private void limparCampos() {
        this.telaView.getTextNomeEstacionamento().setText("");
        this.telaView.getSpinnerQuantidadeVagas().setValue(1);
    }

    private void fecharTelaView() {
        this.telaView.setVisible(false);
    }
}