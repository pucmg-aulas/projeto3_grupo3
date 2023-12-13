package parking.archive;

import parking.model.*;
import parking.model.Cliente;
import parking.DB.XulambsDB;

import java.sql.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClienteArchive extends AbstractArchive {

    private static ClienteArchive clienteArchive;
    private List<Cliente> clientes;

    private final String filePath = "./src/parking/data/Cliente.dat";
    private String tableName;

    private ClienteArchive() {
        clientes = fileRead(filePath);
    }

    public static ClienteArchive getInstance() {
        if (clienteArchive == null) {
            clienteArchive = new ClienteArchive();
        }
        return clienteArchive;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
        fileWrite(filePath, clientes);
    }

    public void removeCliente(Cliente cliente) {
        clientes.remove(cliente);
        fileWrite(filePath, clientes);
    }

    public void editarClientes(Cliente clienteNovo, Cliente clienteAntigo) {
        clientes.set(clientes.indexOf(clienteAntigo), clienteNovo);
        fileWrite(filePath, clientes);
    }

    public Cliente buscarClientePorId(String id) {
        Iterator<Cliente> iterator = clientes.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }
}

    private List<Cliente> loadClientesFromDatabase() {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection connection = XulambsDB.getConexao();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM  cliente")) {

            while (resultSet.next()) {
                String idCliente = resultSet.getString("idCliente");
                String nomeCliente = resultSet.getString("nomeCliente");


                Cliente cliente = new Cliente(idCliente, nomeCliente);


                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clientes;
    }

    private void insertClienteIntoDatabase(Cliente cliente) {
        try (Connection connection = XulambsDB.getConexao();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO " + tableName + "(idCliente, nomeCliente) VALUES (?, ?)")) {

            preparedStatement.setString(1, cliente.getId());
            preparedStatement.setString(2, cliente.getNome());


            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteClienteFromDatabase(Cliente cliente) {
        try (Connection connection = XulambsDB.getConexao();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM " + tableName + " WHERE id = ?")) {

            preparedStatement.setString(1, cliente.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void updateClienteInDatabase(Cliente clienteNovo, Cliente clienteAntigo) {
        try (Connection connection = XulambsDB.getConexao();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE " + tableName + " SET nome = ? WHERE id = ?")) {

            preparedStatement.setString(1, clienteNovo.getNome());
            preparedStatement.setString(2, clienteAntigo.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}



