package parking.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String id;
    private List<Veiculo> veiculos;

    public Cliente(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }

    public void addVeiculo(Veiculo veiculo) {
        List<Veiculo> newVeiculos = new ArrayList<>(veiculos);
        newVeiculos.add(veiculo);
        veiculos = newVeiculos;
    }

    public Veiculo possuiVeiculo(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo; // Veículo encontrado
            }
        }
        return null;
    }

    public int totalDeUsos() {
        int total = 0;
        for (Veiculo veiculo : veiculos) {
            total += veiculo.getTotalDeUsos();
        }
        return total;
    }

    public double arrecadadoPorVeiculo(String placa) {
        Veiculo veiculo = possuiVeiculo(placa);
        if (veiculo == null) {
            return 0.0;
        }
        return veiculo.getArrecadado();
    }

    public double arrecadadoTotal() {
        double total = 0.0;
        for (Veiculo veiculo : veiculos) {
            total += veiculo.getArrecadado();
        }
        return total;
    }

    public double arrecadadoNoMes(int mes) {
        double total = 0.0;
        for (Veiculo veiculo : veiculos) {
            total += veiculo.arrecadadoNoMes(mes);
        }
        return total;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}