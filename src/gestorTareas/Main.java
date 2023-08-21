package gestorTareas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorDeTareas gestor = new GestorDeTareas();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n*** Gestor de Tareas ***");
            System.out.println("1. Añadir tarea");
            System.out.println("2. Mostrar tareas");
            System.out.println("3. Modificar tarea");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        gestor.añadirTarea();
                        break;
                    case 2:
                        gestor.mostrarTarea();
                        break;
                    case 3:
                        gestor.modificarTarea();
                        break;
                    case 4:
                        gestor.eliminarTarea();
                        break;
                    case 5:
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, elige una opción del 1 al 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido.");
                opcion = 0;
            }

        } while (opcion != 5);

        scanner.close();
    }

}


