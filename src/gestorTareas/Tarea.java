/*
Desarrolla una aplicación que permita al usuario añadir, modificar, eliminar y ver tareas pendientes.
Cada tarea tendrá una descripción, una fecha de vencimiento y una prioridad (baja, media, alta).
*/

package gestorTareas;

import java.time.LocalDate;

public class Tarea {
    private String descripcion;
    private LocalDate fechaVencimiento;
    private String prioridad;

    public Tarea(String descripcion, LocalDate fechaVencimiento, String prioridad) {
        this.descripcion = descripcion;
        this.fechaVencimiento = fechaVencimiento;
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "Tarea: " + descripcion + " ,FechaVencimiento: " + fechaVencimiento +
                " ,Prioridad: " + prioridad;
    }
}
