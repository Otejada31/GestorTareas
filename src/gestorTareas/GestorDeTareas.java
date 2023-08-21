package gestorTareas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorDeTareas {

    private ArrayList<Tarea> tareas;
    public Scanner entrada;

    public GestorDeTareas() {
        this.tareas = new ArrayList<>();
        this.entrada = new Scanner(System.in);
    }


    public void añadirTarea(){
        char respuesta;
            do {
                System.out.println("Digite la tarea que desea añadir: ");
                String descripcion= entrada.nextLine();

                LocalDate fechaVencimiento = null;
                boolean fechaValida = false;
                while (!fechaValida) {
                    try {
                        System.out.println("Introduce la fecha de vencimiento (formato YYYY-MM-DD):");
                        fechaVencimiento = LocalDate.parse(entrada.nextLine());
                        fechaValida = true;
                    } catch (Exception e) {
                        System.out.println("Fecha no válida. Por favor, introduce una fecha en el formato correcto.");
                    }
                }

                System.out.println("Introduce la prioridad (baja, media, alta):");
                String prioridad = entrada.nextLine();

                Tarea nuevaTarea = new Tarea(descripcion, fechaVencimiento, prioridad);
                tareas.add(nuevaTarea);

                System.out.println("Tarea añadida correctamente!");

                System.out.print("Desea ingresar otra tarea(s/n): ");
                respuesta = entrada.nextLine().charAt(0);
                System.out.println("");

            }while (respuesta=='s' || respuesta=='S');


    }

    public void mostrarTarea(){
        for (Tarea tarea : tareas) {
            System.out.println(tarea.toString());
        }

    }
    public void modificarTarea(){
        if(tareas.isEmpty()){
            System.out.println("No hay tareas por modificar");
            return;
        }
        System.out.println("Ingrese el numero de la tarea que desea modificar: ");
        int indice = Integer.parseInt(entrada.nextLine()) - 1;

        if (indice<0 || indice>= tareas.size()){
            System.out.println("Numero de tarea invalido");
            return;
        }
        Tarea tareaSeleccionada = tareas.get(indice);

        System.out.println("¿Qué deseas modificar?");
        System.out.println("1. Descripción");
        System.out.println("2. Fecha de vencimiento");
        System.out.println("3. Prioridad");
        int eleccion = Integer.parseInt(entrada.nextLine());

        switch (eleccion) {
            case 1:
                System.out.println("Introduce la nueva descripción:");
                String nuevaDescripcion = entrada.nextLine();
                tareaSeleccionada.setDescripcion(nuevaDescripcion);
                break;
            case 2:
                LocalDate nuevaFecha = null;
                boolean fechaValida = false;
                while (!fechaValida) {
                    try {
                        System.out.println("Introduce la nueva fecha de vencimiento (formato YYYY-MM-DD):");
                        nuevaFecha = LocalDate.parse(entrada.nextLine());
                        fechaValida = true;
                    } catch (Exception e) {
                        System.out.println("Fecha no válida. Introduce una fecha en el formato correcto.");
                    }
                }
                tareaSeleccionada.setFechaVencimiento(nuevaFecha);
                break;
            case 3:
                System.out.println("Introduce la nueva prioridad (baja, media, alta):");
                String nuevaPrioridad = entrada.nextLine();
                tareaSeleccionada.setPrioridad(nuevaPrioridad);
                break;
            default:
                System.out.println("Opción inválida.");
        }

    }
    public void eliminarTarea(){
        System.out.println("Ingrese el numero de tarea que desea eliminar: ");
        int indice = Integer.parseInt(entrada.nextLine()) - 1;

        if (indice<0 || indice>= tareas.size()){
            System.out.println("Numero de tarea invalido");
            return;
        }

        Tarea tareaSeleccionada = tareas.remove(indice);
        System.out.println("Tarea eliminada correctamente.");



    }


}
