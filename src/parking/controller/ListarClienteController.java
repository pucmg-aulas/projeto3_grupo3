package parking.controller;

import parking.archive.ClienteArchive;
import parking.view.ListarClienteView;

// import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Iterator;
import parking.model.Cliente;

public class ListarClienteController {

    private final ListarClienteView telaView;
    private ClienteArchive clienteArchive;

    private static ListarClienteController ListarClienteController;

    public static ListarClienteController getInstance() {
        if (ListarClienteController == null) 
            ListarClienteController = new ListarClienteController();
           
        return ListarClienteController;
    }
    
    private ListarClienteController() {

        telaView = new ListarClienteView();
        clienteArchive = ClienteArchive.getInstance();

        carregarTabela();

        telaView.getButtonVoltar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telaView.setVisible(false);
            }
        });

        // telaView.getButtonEditar().addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         editarCliente();
        //     }
        // });

        // telaView.getButtonExcluir().addActionListener(new java.awt.event.ActionListener() {
        //     public void actionPerformed(java.awt.event.ActionEvent evt) {
        //         excluirCliente();
        //     }
        // });

        telaView.setVisible(true);
    }

    private void carregarTabela() {
        Object colunas[] = {"Id", "Nome", "Telefone", "Endereço"};
        DefaultTableModel tm = new DefaultTableModel(colunas, 0);
        tm.setNumRows(0);

        Iterator<Cliente> it = clienteArchive.getClientes().iterator();
        while (it.hasNext()) {
            Cliente cliente = it.next();
            tm.addRow(new Object[]{cliente.getId(), cliente.getNome(), "vazio", "vazio"});
        }

        telaView.getTableClientes().setModel(tm);
    }

    // private void editarCliente() {
    //     int linhaSelecionada = telaView.getTableClientes().getSelectedRow();
    //     if (linhaSelecionada >= 0) {
    //         String cpf = (String) telaView.getTableClientes().getValueAt(linhaSelecionada, 1);
    //         Cliente cliente = clienteArchive.getCliente(cpf);
    //         new AddClienteController(cliente);
    //         carregarTabela();
    //     } else {
    //         JOptionPane.showMessageDialog(null, "Selecione um cliente para editar.");
    //     }
    // }

    // private void excluirCliente() {
    //     int linhaSelecionada = telaView.getTableClientes().getSelectedRow();
    //     if (linhaSelecionada >= 0) {
    //         String cpf = (String) telaView.getTableClientes().getValueAt(linhaSelecionada, 1);
    //         clienteArchive.removerCliente(cpf);
    //         carregarTabela();
    //     } else {
    //         JOptionPane.showMessageDialog(null, "Selecione um cliente para excluir.");
    //     }
    // }

}
