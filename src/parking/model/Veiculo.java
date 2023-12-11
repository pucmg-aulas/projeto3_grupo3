package parking.model;

import java.io.Serializable;

public class Veiculo implements Serializable {

    private UsoDeVaga usoDeVaga;
    private String placa;
    private String vaga;
    private Vaga vaga2;

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

    public void estacionar(Vaga vaga, Veiculo carro) {
        // vaga.ocupada = true;
        // vaga.veiculo = carro
    }

    public double sair(String placa) {
        // vaga.ocupada = false;
        // vaga.veiculo = null;
        return 0.0;
    }

    public double totalArrecadado() {

        // boolean disponivel = true;
        // int vagaNumero = 0;
        // Vaga vaga = new Vaga(vagaNumero, disponivel);
        // UsoDeVaga usoDeVaga = new UsoDeVaga(vaga);
        // double total = usoDeVaga.getValorPago();

        // for (int i = 2; i <= 10; i++) {
        // vaga = new Vaga(i, disponivel);
        // vagaNumero = vaga.getNumero();
        // usoDeVaga = new UsoDeVaga(vaga);
        // total += usoDeVaga.getValorPago();
        // }
        // return total;
        return 0.0;

    }

    public double arrecadadoNoMes(int mes) {
        double total = 0.0;
        for (int i = 0; i < 10; i++) {
            total += usoDeVaga.getValorPago();
        }
        return total;
    }

    public int totalDeUsos() {
        return 0;
    }

    public int getTotalDeUsos() {
        return 0;
    }
    

    public double getArrecadado() {
        double total = 0.0;
        for (int i = 0; i < 10; i++) {
        total += usoDeVaga.getValorPago();
        }
        return total;
    }

    @Override
    public String toString() {
        return placa + "%" + vaga;
    }
}