package parking.model;

import java.io.Serializable;

public class Veiculo implements Serializable {

    private String placa;
    private String vaga;

    public Veiculo(String placa, String vaga) {
        this.placa = placa;
        this.vaga = vaga;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getVaga() {
        return vaga;
    }

    public void setUsos(String vaga) {
        this.vaga = vaga;
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

    public int getTotalDeUsos() {
        return 0;
    }

    public double getArrecadado() {
        return 0;
    }

    @Override
    public String toString() {
        return placa + "%" + vaga;
    }
}