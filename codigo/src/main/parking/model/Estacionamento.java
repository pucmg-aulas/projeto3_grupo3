package parking.model;

public class Estacionamento {
    private String nome;
    private Cliente id;
    private Vaga vagas;
    private int quantFileiras;
    private int vagasPorFileira;

    public Estacionamento(String nome, int quantFileiras, int vagasPorFileira) {
        this.nome = nome;
        this.quantFileiras = quantFileiras;
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
