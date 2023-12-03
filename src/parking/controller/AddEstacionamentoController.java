package parking.controller;

import parking.view.AddEstacionamentoView;

public class AddEstacionamentoController {
    
    private AddEstacionamentoView telaView;

    public AddEstacionamentoController() {
        
        telaView = new AddEstacionamentoView();

        // telaView.getButtonSalvar().addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         adicionarEstacionamento();
        //     }
        // });

        telaView.getButtonCancelar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharTelaView();
            }
        });

        telaView.setVisible(true);
    }

    // private void adicionarEstacionamento() {

    //     String estacionamentoNome = this.telaView.getTextNomeEstacionamento().getText();
    //     int quantidadeVagas = (int) this.telaView.getSpinnerQuantidadeVagas().getValue();

    //     Estacionamento novoEstacionamento = new Estacionamento(estacionamentoNome, quantidadeVagas);

    //     estacionamentoArchive.addEstacionamento(novoEstacionamento);

    //     JOptionPane.showMessageDialog(this.telaView, "Estacionamento salvo com sucesso!");

    //     limparCampos();
    // }

    // private void limparCampos() {
    //     this.telaView.getTextNomeEstacionamento().setText("");
    //     this.telaView.getSpinnerQuantidadeVagas().setValue(1);
    // }

    private void fecharTelaView() {
        this.telaView.setVisible(false);
    }
}