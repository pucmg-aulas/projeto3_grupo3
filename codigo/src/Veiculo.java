public class Veiculo {
    private String placa;
    private UsoDeVaga usos;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public UsoDeVaga getUsos() {
        return usos;
    }

    public void setUsos(UsoDeVaga usos) {
        this.usos = usos;
    }

    public Veiculo(String placa) {
        this.placa = placa;
    }

    public void estacionar(Vaga vaga){

    }

    public double sair(){
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
