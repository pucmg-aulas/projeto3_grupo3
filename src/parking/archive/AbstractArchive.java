package parking.archive;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractArchive {
    
    public <T> void fileWrite(String local, List<T> lista) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(local))) {
            objectOutputStream.writeObject(lista);
            System.out.println("Dados gravados com sucesso");
        } catch (IOException e) {
            System.err.println("Erro ao serializar: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> fileRead(String local) {
        List<T> retorno = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(local))) {
            retorno = (List<T>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao desserializar: " + e.getMessage());
        }
        return retorno;
    }
}