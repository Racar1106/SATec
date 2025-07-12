package project.vista;

import java.util.Scanner;
import java.util.ArrayList;
import project.controlador.ControladorProveedor;
import project.modelo.Proveedor;

public class VistaProveedor {
    ControladorProveedor controlador;
    public VistaProveedor(ControladorProveedor controlador){
        this.controlador = controlador;
    }

    public void administrarProveedores(){
        System.out.println("Administrar proveedores");
        System.out.println("1. Agregar Proveedor");
        System.out.println("2. Regresar al menú principal");
    }

    public void agregarProveedor(Scanner scanner){
        scanner.nextLine();
        System.out.println("Ingrese la identificación del proveedor: ");
        String identificación = scanner.nextLine();
        System.out.println("Ingrese el nombre del proveedor: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el teléfono del proveedor: ");
        String teléfono = scanner.nextLine();
        System.out.println("Ingrese la descripción del proveedor: ");
        String descripción = scanner.nextLine();
        MensajeUsuario m = controlador.agregarProveedor(identificación, nombre, teléfono, descripción);
        if (m!=null){
            mostrarMensaje(m.toString());
        }else{
            mostrarMensaje("Proveedor agregado");
        }
    }

    public void mostrarProveedores(){
        if(controlador.getListaProveedores().isEmpty()){
            System.out.println("No hay proveedores registrados");
        } else{
            mostrarProveedores(controlador.getListaProveedores());
        }
    }

    public void mostrarProveedores(ArrayList<Proveedor> proveedores){
        System.out.printf("%-20s %-20s %-20s %-10s\n", "Identificación", "Nombre", "Teléfono", "Descripción");
        System.out.println(new String(new char[70]).replace("\0", "-"));
        for(Proveedor proveedor:proveedores){
            System.out.println(proveedor);
        }
    }

    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
}
