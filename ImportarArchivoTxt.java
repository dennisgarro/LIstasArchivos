import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ImportarArchivoTxt {

    public LinkedList<Animal> leerArchivo(String nombreArchivo) {
        String rutaArchivo = nombreArchivo + ".txt";
        LinkedList<Animal> Animales = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String line;
            Animal animal = null;
            while ((line = br.readLine()) != null) {
                // Ignorar separadores o líneas vacías
                if (line.trim().isEmpty() || line.startsWith("-")) {
                    continue;
                }

                // Iniciar un nuevo objeto Animal al encontrar "Categoria"
                if (line.startsWith("Categoria: ")) {
                    if (animal != null) {
                        Animales.add(animal); // Añadir el animal anterior a la lista
                    }
                    animal = new Animal();
                    animal.setCategoria(line.substring(11).trim()); // Ajustar para "Categoria: "
                } else if (line.startsWith("Nombre: ") && line.length() > 8) {
                    if (animal != null) {
                        animal.setNombre(line.substring(8).trim()); // Remover "Nombre: "
                    }
                } else if (line.startsWith("Color: ") && line.length() > 7) {
                    if (animal != null) {
                        animal.setColor(line.substring(7).trim()); // Remover "Color: "
                    }
                } else if (line.startsWith("Edad: ") && line.length() > 6) {
                    if (animal != null) {
                        animal.setEdad(Integer.parseInt(line.substring(6).trim())); // Remover "Edad: "
                    }
                }
            }

            // Añadir el último animal leido
            if (animal != null) {
                Animales.add(animal);
            }

            System.out.println("Archivo importado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Animales;
    }
}
