import java.util.LinkedList;
import java.util.Scanner;

public class Metodos {
    public LinkedList<Animal> LLenarLista() {
        LinkedList<Animal> lista = new LinkedList<>();
        boolean bandera = true;
        int opt = 0;
        Scanner sc = new Scanner(System.in);
        while (bandera) {
            Animal a = new Animal();
            System.out.println("Ingrese la categoria");
            a.setCategoria(sc.next());
            System.out.println("Ingrese el nombre");
            a.setNombre(sc.next());
            System.out.println("Ingrese el color");
            a.setColor(sc.next());
            System.out.println("Ingrese la edad del animal");
            a.setEdad(sc.nextInt());
            lista.add(a);

            System.out.println("Desea Continuar 1: Si, 2: No");
            opt = sc.nextInt();
            if (opt == 2) {
                bandera = false;
            }
        }
        return lista;
    }

    public void MostrarLista(LinkedList<Animal> lista) {
        for (Animal animal : lista) {
            System.out.println("Categoria: " + " " + animal.getCategoria());
            System.out.println("Nombre: " + " " + animal.getNombre());
            System.out.println("Color: " + " " + animal.getColor());
            System.out.println("Edad: " + " " + animal.getEdad());
            System.out.println("------------------------------- \n");

        }
    }

    public void ExportarArchivo(LinkedList<Animal> lista) {
        ExportarArchivo e = new ExportarArchivo();
        e.exportarArchivo(lista);
    }

    public LinkedList<Animal> ImportarArchivo() {
        ImportarArchivoTxt i = new ImportarArchivoTxt();
        LinkedList<Animal> lista = i.leerArchivo("Animales");
        return lista;
    }

    public Animal Buscar(LinkedList<Animal> lista) {
        Scanner sc = new Scanner(System.in);
        String nombreBuscar = "";
        System.out.println("Ingrese el nombre a buscar");
        nombreBuscar = sc.next();
        Animal obj = new Animal();
        for (Animal animal : lista) {
            if (animal.getNombre().equalsIgnoreCase(nombreBuscar)) {
                obj = animal;
            }
        }
        return obj;
    }
}
