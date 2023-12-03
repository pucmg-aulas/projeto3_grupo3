package parking.archive;

import parking.model.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VeiculoArchive extends AbstractArchive implements Serializable {

    private List<Veiculo> veiculos;
    private static VeiculoArchive veiculoArchive;
    private final String filePath = "./src/parking/data/Veiculo.dat";

    private VeiculoArchive() {
        veiculos = new ArrayList<>();
        carregaVeiculos();
    }

    public static VeiculoArchive getInstance() {
        if (veiculoArchive == null) {
            veiculoArchive = new VeiculoArchive();
        }
        return veiculoArchive;
    } // * Por ser singleton não precisa do 'this'

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    private void carregaVeiculos() {
        veiculos = fileRead(filePath);
    }

    public void addVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
        fileWrite(filePath, veiculos);
    }

    public void removeVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
        fileWrite(filePath, veiculos);
    }

    public void editarVeiculo(Veiculo veiculoNovo, Veiculo veiculoAntigo) {
        veiculos.set(veiculos.indexOf(veiculoAntigo), veiculoNovo);
        fileWrite(filePath, veiculos);
    }

    public Veiculo buscarVeiculoPorPlaca(String placa) {
        Iterator<Veiculo> iterator = veiculos.iterator();
        while (iterator.hasNext()) {
            Veiculo veiculo = iterator.next();
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }
}
