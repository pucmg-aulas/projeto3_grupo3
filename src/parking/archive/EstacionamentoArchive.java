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

}
