package parking.model;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class UsoDeVaga implements Serializable {
    static final double FRACAO_USO = 0.25;
    static final double VALOR_FRACAO = 4.0;
    static final double VALOR_MAXIMO = 50.0;
    private Vaga vaga;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private double valorPago;
    private List<UsoDeVaga> usoDeVagas; 

    public UsoDeVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public double sair(){
        this.saida = LocalDateTime.now();
        Duration duracao = Duration.between(entrada, saida);
        int minutos = (int) duracao.toMinutes();
        valorPago = calcularValorPago(minutos);
        vaga.sair();
        return valorPago;
    }

    private double calcularValorPago(int minutos) {
        double totalValorPago = 0.0;
        if (minutos > 0) {
            totalValorPago = VALOR_FRACAO * minutos;
            if (totalValorPago > VALOR_MAXIMO) {
                totalValorPago = VALOR_MAXIMO;
            }
        }
        return totalValorPago;
    }

    public double getValorPago() {
        return valorPago;
    }

    public double valorPago() {
        double total = 0.0;
        if (entrada != null && saida != null) {
            Duration duracao = Duration.between(entrada, saida);
            int minutos = (int) duracao.toMinutes();
            total = calcularValorPago(minutos);
        }
        return total;
    }


public double tempoDeUso() {
    double totalDeTempo = 0.0;
    if (entrada != null && saida != null) {
        Duration duracao = Duration.between(entrada, saida);
        totalDeTempo = duracao.toMinutes();
    }
    return totalDeTempo;
} 




public double valorPagoMes(int mes) {
    double total = 0.0;
    for (UsoDeVaga usoDeVaga : usoDeVagas) {
        if (usoDeVaga.entrada.getMonthValue() == mes || usoDeVaga.saida.getMonthValue() == mes) {
            total += usoDeVaga.valorPago();
        }
    }
    return total;
} 

}
    

