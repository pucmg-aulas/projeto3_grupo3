package parking.model;

import java.util.List;

import parking.archive.EstacionamentoArchive;

import java.io.Serializable;
public class Estacionamento implements Serializable {

    private String nome;
    private List<Vaga> vagas;

    public Estacionamento(String nome, List<Vaga> vagas) {
        this.nome = nome;
        this.vagas = vagas;
    }

    public Estacionamento(String nome) {
        this.nome = nome;
        this.vagas = null;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public List<Vaga> getVagas(){
        return vagas;
    }

    public void setVagas(List<Vaga> vagas){
        this.vagas = vagas;
    }

    public void EstacionarCarro (Veiculo veiculo){
        for (Vaga vaga : vagas) {
            if (vaga.getVeiculo() == null) {
                vaga.setVeiculo(veiculo);
                return ;
            } else {
                System.out.println("Todas vagas lotada");
                return ;
            }
        }
    }

    public double totalArrecadado(){ 
        return 0.0;
    }

    public double arrecadacaoNoMes(int mes) {
        double total = 0.0;
        for (Vaga vaga : vagas) {
            Veiculo veiculo = vaga.getVeiculo();
            if (veiculo != null) {
                total += veiculo.arrecadadoNoMes(mes);
            }
        }
        return total;
    }

    public double valorMedioPorUso() {
        double mediaPorUso = 0.0;
        int contador = 0; 
        for (Vaga vaga : vagas) {
            Veiculo veiculo = vaga.getVeiculo();
            if (veiculo != null) {
                contador++;
                mediaPorUso += veiculo.getArrecadado();
            }
        }
        return (contador > 0) ? mediaPorUso / contador : 0.0; 
    }

    public String top5Clientes(int mes){
        double total = 0.0;
        for (Vaga vaga : vagas) {
            Veiculo veiculo = vaga.getVeiculo();
            if (veiculo != null) {
                total += veiculo.arrecadadoNoMes(mes);
            }
        
        }
        return "Top 5 clientes: " + total;
    }

    public static void addEstacionamento(Estacionamento novoEstacionamento) {
        EstacionamentoArchive estacionamentoArchive = EstacionamentoArchive.getInstance();
        estacionamentoArchive.addEstacionamento(novoEstacionamento);
        
    }

    public String getId() {
        return null;
    }
}