import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class ExportarArchivo {

    public void exportarArchivo(LinkedList<Animal> listaAnimales) {
        if (listaAnimales.isEmpty()) {
            Metodos ll = new Metodos();
            listaAnimales = ll.LLenarLista();
        } else {
            try (FileWriter escriba = new FileWriter("Animales.txt")) {
                for (Animal animal : listaAnimales) {
                    escriba.write("Categoria: " + animal.getCategoria() + "\n" );
                    escriba.write("Nombre: " + animal.getNombre() + "\n");
                    escriba.write("Color: " + animal.getColor() + "\n");
                    escriba.write("Edad: " + animal.getEdad() + "\n");
                    escriba.write("---------------------------------------\n");

                }

                System.out.println("Archivo exportado correctamente");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
