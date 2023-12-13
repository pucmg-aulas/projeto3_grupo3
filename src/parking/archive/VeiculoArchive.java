package parking.archive;

import parking.DB.XulambsDB;
import parking.model.*;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

public class VeiculoArchive extends AbstractArchive {

    private static String banco = "xulambs";
    private static String usuario = "root";
    private static String senha = "laranbanas02.";
    private static String url = "jdbc:mariadb://localhost:3306/xulambs";

    private static XulambsDB instancia = null;
    private static Connection conexao = null;

    private static VeiculoArchive veiculoArchive;
    private List<Veiculo> veiculos;

    private final String filePath = "./src/parking/data/Veiculo.dat";

    private VeiculoArchive() {
        veiculos = fileRead(filePath);
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