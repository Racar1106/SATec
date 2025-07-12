package project.vista;

import java.util.Scanner;
import project.controlador.ControladorReporteIngresoServicio;
import project.modelo.DetalleServicio;
import project.modelo.Servicio;

public class VistaReporteIngresoServicio {
    ControladorReporteIngresoServicio controlador;

    public VistaReporteIngresoServicio(ControladorReporteIngresoServicio controlador){
        this.controlador = controlador;
    }

    public void ReporteIngresoServicio(Scanner scanner){
        scanner.nextLine();
        System.out.println("=== Reporte de ingresos por servicios ===");
        System.out.println("Ingrese año: ");
        int año = scanner.nextInt();

        System.out.println("Ingrese mes: ");
        int mes = scanner.nextInt();

        System.out.printf("%-20s %-10s\n","Servicio","Total");
        for(DetalleServicio detalleServicio:controlador.getListaFiltrada(año, mes)){
            Servicio servicio = detalleServicio.getServicio();
            int cantidad = detalleServicio.getCantidad();
            double total = controlador.getTotalServicio(servicio, cantidad);

            System.out.printf("%-20s %-10s\n", servicio.getNombre(),total);
        }
    }
}
