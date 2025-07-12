package project.vista;

import java.text.DateFormatSymbols;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import project.controlador.ControladorFactura;
import project.modelo.DetalleServicio;
import project.modelo.OrdenServicio;
import project.modelo.Servicio;
import project.modelo.Factura;

public class VistaFactura {
    private ControladorFactura controladorFactura;

    public VistaFactura(ControladorFactura controladorFactura) {
        this.controladorFactura = controladorFactura;
    }

    public void generarFactura(Scanner scanner) {
        scanner.nextLine();
        System.out.println("=== Generar facturas a empresas === ");

        System.out.print("Ingrese cédula de la empresa: ");
        String cedula = scanner.nextLine();

        System.out.print("Ingrese año (ej: 2025): ");
        int año = scanner.nextInt();

        System.out.print("Ingrese mes (1-12): ");
        int mes = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        controladorFactura.generarFacturaEmpresarial(cedula, año, mes);
    }

    public void mostrarFactura(Factura factura, double total) {
        System.out.println("Empresa: " + factura.getCliente().getNombre());
        System.out.println("Periodo de facturación: " + obtenerNombreMes(factura.getMes()) + " " + factura.getAño());
        System.out.println("Detalle de servicios:");
        System.out.printf("%-10s %-10s %-10s %-15s %-10s %-10s\n","#Placa","Fecha","Tipo","Servicio","Cantidad","Total");

        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM");

        for (OrdenServicio orden : factura.getOrdenes()) {
            String tipoVehiculo = orden.getVehículo().getTipoVehículo().toString();

            for (DetalleServicio detalleServicio : orden.getListaDetalleServicio()) {
                Servicio servicio = detalleServicio.getServicio();
                int cantidad = detalleServicio.getCantidad();
                double subtotal = servicio.getPrecio() * cantidad;

                System.out.printf("%-10s %-10s %-10s %-15s %-10s %-10s\n",
                        orden.getVehículo().getPlaca(),
                        orden.getFecha().format(formatoFecha),
                        tipoVehiculo,
                        servicio.getNombre(),
                        cantidad,
                        subtotal);
            }
        }

        System.out.println("Total a pagar: $" + total);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    private String obtenerNombreMes(int mes) {
        return new DateFormatSymbols().getMonths()[mes - 1];
    }
}
