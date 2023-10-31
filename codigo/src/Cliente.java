public class Cliente {
    private String nome;
    private String id;
    private Veiculo veiculos;

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

    public Veiculo getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Veiculo veiculos) {
        this.veiculos = veiculos;
    }

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
