package parking.controller;

import parking.view.AddClienteView;
import javax.swing.JOptionPane;
import parking.archive.ClienteArchive;
import parking.model.Cliente;

public class AddClienteController {

    private AddClienteView telaView;
    private ClienteArchive clienteArchive;

    public AddClienteController() {
        
        telaView = new AddClienteView();
        clienteArchive = ClienteArchive.getInstance();

        telaView.getButtonSalvar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarCliente();
            }
        });

        telaView.getButtonCancelar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharTelaView();
            }
        });

        telaView.setVisible(true);
    }

    private void adicionarCliente() {

        String clienteNome = this.telaView.getTextNomeCliente().getText();
        String clienteId = this.telaView.getTextIdCliente().getText();

        Cliente novoCliente = new Cliente(clienteNome, clienteId);

        clienteArchive.addCliente(novoCliente);

        JOptionPane.showMessageDialog(this.telaView, "Cliente salvo com sucesso!");

        limparCampos();
    }

    private void limparCampos() {
        this.telaView.getTextNomeCliente().setText("");
        this.telaView.getTextIdCliente().setText("");
    }

    private void fecharTelaView() {
        this.telaView.setVisible(false);
    }
}