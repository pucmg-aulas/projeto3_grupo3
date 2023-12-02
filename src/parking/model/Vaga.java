package parking.model;

public class Vaga {

    private Integer id;
    private int fila;
    private int numero;
    private boolean disponivel;

    public Vaga(int fila, int numero) {
        this.fila = fila;
        this.numero = numero;
    }

    public boolean estacionar() {

        if (disponivel) {
            disponivel = false;
            return true;
        } else {
            return false;
        }
    }

    public boolean sair(){
        return false;
    }

    public boolean disponivel(){
        return disponivel;
    }

    public Integer getId() {
        return this.id;
    }

    public int getFila() {
        return this.fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        if (numero > 0) {
            this.numero = numero;
        }
    }
}