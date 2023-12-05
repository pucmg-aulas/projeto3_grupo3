package parking.model;

import java.util.List;
import java.io.Serializable;
public class Estacionamento implements Serializable {

    private String nome;
    private List<Vaga> vagas;

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

    public Estacionamento(String nome, List<Vaga> vagas) {
        this.nome = nome;
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

    public double arrecadacaoNoMes(int mes){
        return 0.0;
    }

    public double valorMedioPorUso(){
        return 0.0;
    }

    public String top5Clientes(int mes){
        return "";
    }

    public static void addEstacionamento(Estacionamento novoEstacionamento) {
        
    }
}