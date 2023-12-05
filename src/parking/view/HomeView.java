package parking.view;

import javax.swing.*;
import java.awt.*;

public class HomeView extends JFrame {

    private JMenuBar jMenuBar = new JMenuBar();
    private JMenu menuAdicionar = new JMenu();
    private JMenu menuExibir = new JMenu();
    private JMenuItem menuItemAddEstacionamento = new JMenuItem();
    private JMenuItem menuItemAddVaga = new JMenuItem();
    private JMenuItem menuItemAddVeiculo = new JMenuItem();
    private JMenuItem menuItemAddCliente = new JMenuItem();
    private JMenuItem menuItemGerenciarVagas = new JMenuItem();
    private JMenuItem menuItemGerenciarClientes = new JMenuItem();
    private JMenuItem menuItemGerenciarEstacionamentos = new JMenuItem();
    private JMenuItem buttonExitMenu = new JMenuItem();
    private JComboBox<String> estacionamentoComboBox = new JComboBox<>();

    public HomeView() {
        initComponents();
        setTitle("Xulambs Parking");
        setLocationRelativeTo(null);
    }

    public JComboBox<String> getEstacionamentoComboBox() {
        return estacionamentoComboBox;
    }

    public void setEstacionamentoComboBox(JComboBox<String> estacionamentoComboBox) {
        this.estacionamentoComboBox = estacionamentoComboBox;
    }

    public JMenuItem getMenuItemAddEstacionamento() {
        return menuItemAddEstacionamento;
    }

    public JMenuItem getMenuItemAddVaga() {
        return menuItemAddVaga;
    }

    public JMenuItem getMenuItemAddVeiculo() {
        return menuItemAddVeiculo;
    }
    public JMenuItem getMenuItemAddCliente() {
        return menuItemAddCliente;
    }

    public JMenuItem getMenuItemGerenciarVagas() {
        return menuItemGerenciarVagas;
    }

    public JMenuItem getMenuItemGerenciarClientes() {
        return menuItemGerenciarClientes;
    }

    public JMenuItem getMenuItemGerenciarEstacionamentos() {
        return menuItemGerenciarEstacionamentos;
    }

    public JMenuItem getButtonExitMenu() {
        return buttonExitMenu;
    }

    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        menuAdicionar.setText("Adicionar");
        menuAdicionar.add(menuItemAddEstacionamento);
        menuAdicionar.add(menuItemAddCliente);
        menuAdicionar.add(menuItemAddVaga);
        menuAdicionar.add(menuItemAddVeiculo);

        menuExibir.setText("Exibir");
        menuExibir.add(menuItemGerenciarVagas);
        menuExibir.add(menuItemGerenciarClientes);
        menuExibir.add(menuItemGerenciarEstacionamentos);

        menuItemAddEstacionamento.setText("Estacionamento");
        menuItemAddCliente.setText("Cliente");
        menuItemAddVeiculo.setText("Veículo");
        menuItemAddVaga.setText("Vaga");

        menuItemGerenciarVagas.setText("Vagas");
        menuItemGerenciarClientes.setText("Clientes");
        menuItemGerenciarEstacionamentos.setText("Estacionamentos");

        buttonExitMenu.setText("Sair");

        buttonExitMenu.setHorizontalAlignment(SwingConstants.RIGHT);

        jMenuBar.add(menuAdicionar);
        jMenuBar.add(menuExibir);
        jMenuBar.add(estacionamentoComboBox);
        jMenuBar.add(buttonExitMenu);

        setJMenuBar(jMenuBar);

        setLayout(new FlowLayout());
        add(new JLabel("Bem vindo ao Xulambs Parking!"));

        setPreferredSize(new Dimension(400, 300));

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HomeView().setVisible(true);
            }
        });
    }
}
