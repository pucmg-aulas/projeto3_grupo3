package parking.archive;

import parking.model.Estacionamento;

import java.util.List;

public class EstacionamentoArchive extends AbstractArchive {

    private static EstacionamentoArchive estacionamentoArchive;
    private List<Estacionamento> estacionamentos;

    private final String filePath = "./src/parking/data/Estacionamento.dat";

    private EstacionamentoArchive() {
        estacionamentos = fileRead(filePath);
    }

    public static EstacionamentoArchive getInstance() {
        if (estacionamentoArchive == null) {
            estacionamentoArchive = new EstacionamentoArchive();
        }
        return estacionamentoArchive;
    }

    public List<Estacionamento> getEstacionamentos() {
        return estacionamentos;
    }

    public void addEstacionamento(Estacionamento estacionamento) {
        estacionamentos.add(estacionamento);
        fileWrite(filePath, estacionamentos);
    }

    public void removeEstacionamento(Estacionamento estacionamento) {
        estacionamentos.remove(estacionamento);
        fileWrite(filePath, estacionamentos);
    }

    public void editarEstacionamento(Estacionamento estacionamentoNovo, Estacionamento estacionamentoAntigo) {
        estacionamentos.set(estacionamentos.indexOf(estacionamentoAntigo), estacionamentoNovo);
        fileWrite(filePath, estacionamentos);
    }

    public Estacionamento buscarEstacionamentoPorNome(String nome) {
        for (Estacionamento estacionamento : estacionamentos) {
            if (estacionamento.getNome().equals(nome)) {
                return estacionamento;
            }
        }
        return null;
    }
}
