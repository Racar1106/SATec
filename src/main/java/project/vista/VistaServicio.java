package project.vista;

import java.util.Scanner;
import java.util.ArrayList;
import project.controlador.ControladorServicio;
import project.modelo.Servicio;

public class VistaServicio {
    ControladorServicio controlador;
    public VistaServicio(ControladorServicio controlador){
        this.controlador = controlador;
    }

    public void administrarServicios(){
        System.out.println("Administrar servicios");
        System.out.println("1. Agregar Servicio");
        System.out.println("2. Editar Servicio");
        System.out.println("3. Regresar al menú principal");
    }

    public void agregarServicio(Scanner scanner){
        scanner.nextLine();
        System.out.println("Ingrese el código del servicio: ");
        int código = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el nombre del servicio: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el precio del servicio: ");
        double precio = scanner.nextDouble();
        MensajeUsuario m = controlador.agregarServicio(código, nombre, precio);
        if (m!=null){
            mostrarMensaje(m.toString());
        }else{
            mostrarMensaje("Servicio agregado");
        }
    }

    public void editarServicio(Scanner scanner){
        System.out.println("Ingrese el código del servicio: ");
        int código = scanner.nextInt();
        System.out.println("Ingrese el nuevo precio: ");
        double precio = scanner.nextDouble();
        MensajeUsuario m = controlador.editarServicio(código, precio);
        if(m!=null){
            mostrarMensaje(m.toString());
        } else{
            mostrarMensaje("Se cambió el precio");
        }
    }

    public void mostrarServicios(){
        if(controlador.getListaServicios().isEmpty()){
            System.out.println("No hay servicios registrados");
        } else{
            mostrarServicios(controlador.getListaServicios());
        }
    }

    public void mostrarServicios(ArrayList<Servicio> servicios){
        System.out.printf("%-10s %-20s %-10s\n", "Código", "Nombre", "Precio");
        System.out.println(new String(new char[40]).replace("\0", "-"));
        for(Servicio servicio:servicios){
            System.out.println(servicio);
        }
    }
    
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
}
