public class Cliente {
    private String nome;
    private String id;
    private Veiculo veiculos;


    public Cliente(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }

    public void addVeiculo(Veiculo veiculo){

    }

    public Veiculo possuiVeiculo(String placa){
        return veiculos;
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
}
