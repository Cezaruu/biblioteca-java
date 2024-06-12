package persistencia;

import java.io.*;

public class Persistencia{
    public static void salvarObjeto(Object objeto, String caminho) throws IOException{
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))){
            oos.writeObject(objeto);
        }
    }
    public static Object carregarObjeto(String caminho) throws IOException, ClassNotFoundException{
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))){
            return ois.readObject();
        }
    }
}
