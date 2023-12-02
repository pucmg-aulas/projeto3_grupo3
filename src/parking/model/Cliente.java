package parking.model;

import java.util.List;

public class Cliente {
    private String nome;
    private String id;
    private List<Veiculo> veiculos;

    public Cliente(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }

    public void addVeiculo(Veiculo veiculo){
        this.veiculos.add(veiculo);
    }

    public Veiculo possuiVeiculo(String placa){
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo; // Veículo encontrado
            }
        }
        return null;
    }

    public int totalDeUsos(){
        return 0;
    }

    public double arrecadadoPorVeiculo(String placa){
        return 0.0;
    }

    public double arrecadadoTotal(){
        return 0.0;
    }

    public double arrecadadoNoMes(int mes){
        return 0.0;
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