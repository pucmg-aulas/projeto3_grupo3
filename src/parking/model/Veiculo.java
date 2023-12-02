package parking.model;

import java.util.List;

public class Veiculo {
    private String placa;
    private List<UsoDeVaga> usos;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public List<UsoDeVaga> getUsos() {
        return usos;
    }

    public void setUsos(List<UsoDeVaga> usos) {
        this.usos = usos;
    }

    public Veiculo(String placa) {
        this.placa = placa;
    }

    public void estacionar(Vaga vaga, Veiculo carro){
        // vaga.ocupada = true;
        // vaga.veiculo = carro
    }

    public double sair(String placa){
        // vaga.ocupada = false;
        // vaga.veiculo = null;
        return 0.0;
    }

    public double totalArrecadado(){
        return 0.0;
    }

    public double arrecadadoNoMes(int mes){
        return 0.0;
    }

    public int totalDeUsos(){
        return 0;
    }
}