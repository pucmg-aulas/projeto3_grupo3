package parking.model;

import java.io.Serializable;
public class Estacionamento implements Serializable {

    public String nome;
    public Cliente[] id;
    public Vaga[] vagas;
    public int fileiras;
    public int vagasPorFileira;

    public Estacionamento(String nome, int fileiras, int vagasPorFileira) {
        this.nome = nome;
        this.fileiras = fileiras;
        this.vagasPorFileira = vagasPorFileira;
    }

    public void addVeiculo(Veiculo veiculo, String idCliente){

    }

    public void addCliente(Cliente cliente){

    }

    private void gerarVagas(){

    }

    public void estacionar(String placa){

    }

    public double sair(String placa){
        this.gerarVagas();
        return 0.0;
    }

    public double totalArrecadado(){
        return 0.0;
    }

    public double arrecadacaoNoMes(int mes){
        return 0.0;
    }

    public double valorMedioPorUso(){
        return 0.0;
    }

    public String top5Clientes(int mes){
        return "";
    }
}