package parking.view;

import javax.swing.*;
import java.awt.*;

public class AddEstacionamentoView extends JFrame {

    private JLabel labelNome;
    private JTextField textFieldNome;
    
    private JLabel labelQuantidadeVagas;
    private JSpinner spinnerQuantidadeVagas;

    private JButton buttonSalvar;
    private JButton buttonCancelar;

    public AddEstacionamentoView() {
        initComponents();
        setTitle("Adicionar Estacionamento");
        setLocationRelativeTo(null);
    }

    public JButton getButtonSalvar() {
        return buttonSalvar;
    }

    public JButton getButtonCancelar() {
        return buttonCancelar;
    }

    public JTextField getTextFieldNome() {
        return textFieldNome;
    }
    public JSpinner getSpinnerQuantidadeVagas() {
        return spinnerQuantidadeVagas;
    }
    public JLabel getLabelQuantidadeVagas() {
        return labelQuantidadeVagas;
    }
    public JTextField getTextNomeEstacionamento () {
        return textFieldNome;
    }

    private void initComponents() {
        setLayout(new GridLayout(3, 2, 10, 10));

        labelNome = new JLabel("Nome do Estacionamento:");
        textFieldNome = new JTextField();

        labelQuantidadeVagas = new JLabel("Quantidade de Vagas:");
        spinnerQuantidadeVagas = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));

        buttonSalvar = new JButton("Salvar");
        buttonCancelar = new JButton("Cancelar");

        add(labelNome);
        add(textFieldNome);
        add(labelQuantidadeVagas);
        add(spinnerQuantidadeVagas);
        add(buttonCancelar);
        add(buttonSalvar);

        setPreferredSize(new Dimension(300, 150));

        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AddEstacionamentoView().setVisible(true);
        });
    }
}