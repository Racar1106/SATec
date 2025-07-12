package project.vista;

import java.util.Scanner;
import project.controlador.ControladorFaltaInsumo;
import project.modelo.Proveedor;

public class VistaFaltaInsumo {
    private ControladorFaltaInsumo controlador;

    public VistaFaltaInsumo(ControladorFaltaInsumo controlador) {
        this.controlador = controlador;
    }

    public void registrarFalta(Scanner scanner) {
        scanner.nextLine();
        System.out.println("=== Registrar falta de insumos ===");

        System.out.print("Ingrese descripción de la falta: ");
        String descripcion = scanner.nextLine();

        System.out.println("=== Seleccione proveedor (por identificación) ===");
        for (Proveedor p : controlador.getProveedores()) {
            System.out.println(p.getIdentificación() + " - " + p.getNombre() + " - " + p.getDescripción());
        }
        System.out.print("Ingrese identificación del proveedor: ");
        String idProveedor = scanner.nextLine();

        controlador.registrarFalta(descripcion, idProveedor);
    }
}

