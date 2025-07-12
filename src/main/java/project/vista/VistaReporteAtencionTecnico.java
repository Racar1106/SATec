package project.vista;

import java.util.Scanner;

import project.controlador.ControladorReporteAtencionTecnico;
import project.modelo.Técnico;

public class VistaReporteAtencionTecnico {
    ControladorReporteAtencionTecnico controlador;

    public VistaReporteAtencionTecnico(ControladorReporteAtencionTecnico controlador){
        this.controlador = controlador;
    }

    public void ReporteAtencionTecnico(Scanner scanner){
        scanner.nextLine();
        System.out.println("=== Reporte de atenciones por técnico ===");
        System.out.println("Ingrese año: ");
        int año = scanner.nextInt();

        System.out.println("Ingrese mes: ");
        int mes = scanner.nextInt();

        System.out.printf("%-20s %-10s\n","Técnico","Total");
        for(Técnico técnico : controlador.getListaTécnicos()){
            double total = controlador.getTotalTecnico(técnico, controlador.getListaFiltrada(año, mes));
            System.out.printf("%-20s %-10s\n", técnico.getNombre(),total);
        }
    }
}
