package parking.archive;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public abstract class MainArchive {
    
    public <T> void fileWrite(String local, List<T> lista) {
        try (ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(local))) {
            oo.writeObject(lista);
            System.out.println("Dados gravados com sucesso");
        } catch (IOException e) {
            System.err.println("Erro ao serializar: " + e.getMessage());
        }
    }

    public <T> List<T> fileRead(String local) {
        List<T> retorno = new ArrayList<>();
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(local))) {
            retorno = (List<T>) oi.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao desserializar: " + e.getMessage());
        }
        return retorno;
    }
}