package parking.archive;

import parking.model.Estacionamento;

import java.util.List;
import parking.DB.XulambsDB;

import java.sql.*;
import java.util.ArrayList;


public class EstacionamentoArchive extends AbstractArchive {

    private static String banco = "xulambs";
    private static String usuario = "root";
    private static String senha = "laranbanas02.";
    private static String url = "jdbc:mariadb://localhost:3306/xulambs";

    private static XulambsDB instancia = null;
    private static Connection conexao = null;
    private static EstacionamentoArchive estacionamentoArchive;
    private List<Estacionamento> estacionamentos;

    private final String filePath = "./src/parking/data/Estacionamento.dat";
    private String tableName;

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
    private List<Estacionamento> loadEstacionamentosFromDatabase() {
        List<Estacionamento> estacionamentos = new ArrayList<>();
        try (Connection connection = XulambsDB.getConexao();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName)) {

            while (resultSet.next()) {
                String idEstacionamento = resultSet.getString("idEstacionamento");
                String nomeEstacionamento = resultSet.getString("nomeEstacionamento");

                Estacionamento estacionamento = new Estacionamento(idEstacionamento);

                estacionamentos.add(estacionamento);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return estacionamentos;
    }

    private void insertEstacionamentoIntoDatabase(Estacionamento estacionamento) {
        try (Connection connection = XulambsDB.getConexao();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO " + tableName + "(idEstacionamento, nomeEstacionamento) VALUES (?, ?)")) {

            preparedStatement.setString(1, estacionamento.getId());
            preparedStatement.setString(2, estacionamento.getNome());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteEstacionamentoFromDatabase(Estacionamento estacionamento) {
        try (Connection connection = XulambsDB.getConexao();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM " + tableName + " WHERE idEstacionamento = ?")) {

            preparedStatement.setString(1, estacionamento.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void updateEstacionamentoInDatabase(Estacionamento estacionamentoNovo, Estacionamento estacionamentoAntigo) {
        try (Connection connection = XulambsDB.getConexao();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE " + tableName + " SET nomeEstacionamento = ? WHERE idEstacionamento = ?")) {

            preparedStatement.setString(1, estacionamentoNovo.getNome());
            preparedStatement.setString(2, estacionamentoAntigo.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
