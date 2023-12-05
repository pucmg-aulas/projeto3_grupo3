package parking.archive;

import parking.model.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClienteArchive extends AbstractArchive {

    private List<Cliente> clientes;
    private static ClienteArchive clienteArchive;
    private final String filePath = "./src/parking/data/Cliente.dat";

    private ClienteArchive() {
        clientes = new ArrayList<>();
        carregaClientes();
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

    private void carregaClientes() {
        clientes = fileRead(filePath);
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
