package parking.model;

public class Vaga {
    private String id;
    private boolean disponivel;
    private Veiculo veiculo;

    public Vaga(String id, boolean disponivel) {
        this.id = id;
        this.disponivel = disponivel;
    }

    public boolean estacionar(){
        return false;
    }

    public boolean sair(){
        return false;
    }

    public boolean disponivel(){
        return false;
    }

    public void liberar() {
    }
}