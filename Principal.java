import java.util.LinkedList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Metodos m = new Metodos();
        int opt = 0;
        LinkedList<Animal> lista = new LinkedList<>();
        boolean bandera = true;
        while (bandera) {
            System.out.println("Ingrese  la opcion");
            System.out.println("1: LLenar lista");
            System.out.println("2: Mostrar Lista");
            System.out.println("3: Importar Archivo");
            System.out.println("4: Exportar Archivo");
            System.out.println("5: Buscar por nombre");
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    lista = m.LLenarLista();
                    break;
                case 2:
                    m.MostrarLista(lista);
                    break;
                case 3:
                    lista = m.ImportarArchivo();
                    break;
                case 4:
                    m.ExportarArchivo(lista);
                    break;
                case 5:
                    Animal a = m.Buscar(lista);
                    System.out.println("Categoria: " + " " + a.getCategoria());
                    System.out.println("Nombre: " + " " + a.getNombre());
                    System.out.println("Color: " + " " + a.getColor());
                    System.out.println("Edad: " + " " + a.getEdad());
                    System.out.println("------------------------------- \n");
                    break;

                default:
                    bandera = false;
                    break;
            }
        }
    }
}