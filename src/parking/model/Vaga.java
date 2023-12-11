package parking.model;

import java.io.Serializable;

public class Vaga implements Serializable {

    private int id;
    private int fila;
    private int numero;
    private boolean disponivel;
    private Veiculo veiculo;

    public Vaga(int numero, boolean disponivel) {
        this.numero = numero;
        this.disponivel = disponivel;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
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

        if (!disponivel) {
            disponivel = true;
            return true;
        }
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