package model;

import java.time.LocalDateTime;

public class UsoDeVaga {
    static final double FRACAO_USO = 0.25;
    static final double VALOR_FRACAO = 4.0;
    static final double VALOR_MAXIMO = 50.0;
    private Vaga vaga;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private double valorPago;

    public UsoDeVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public double sair(){
        return 0.0;
    }

    public double valorPago(){
        return 0.0;
    }
}
