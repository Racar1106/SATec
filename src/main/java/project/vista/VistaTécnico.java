package project.vista;

import java.util.Scanner;
import java.util.ArrayList;
import project.controlador.ControladorTécnico;
import project.modelo.Técnico;

public class VistaTécnico {
    ControladorTécnico controlador;
    public VistaTécnico(ControladorTécnico controlador){
        this.controlador = controlador;
    }

    public void administrarTécnicos(){
        System.out.println("Administrar técnicos");
        System.out.println("1. Agregar Técnico");
        System.out.println("2. Eliminar Técnico");
        System.out.println("3. Regresar al menú principal");
    }

    public void agregarTécnico(Scanner scanner){
        scanner.nextLine();
        System.out.println("Ingrese la identificación del técnico: ");
        String identificación = scanner.nextLine();
        System.out.println("Ingrese el nombre del técnico: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el teléfono del técnico: ");
        String teléfono = scanner.nextLine();
        System.out.println("Ingrese la especialidad del técnico: ");
        String especialidad = scanner.nextLine();
        MensajeUsuario m = controlador.agregarTecnico(identificación, nombre, teléfono, especialidad);
        if (m!=null){
            mostrarMensaje(m.toString());
        }else{
            mostrarMensaje("Técnico agregado");
        }
    }
    
    public void eliminarTécnico(Scanner scanner){
        scanner.nextLine();
        System.out.println("Ingrese la identificación del técnico: ");
        String identificación = scanner.nextLine();
        System.out.println("Está seguro que desea eliminar el registro? (Si/No):");
        String confirmación = scanner.nextLine();
        if(confirmación.equals("Si")){
            MensajeUsuario m = controlador.eliminarTécnico(identificación);
            if(m!=null){
                mostrarMensaje(m.toString());
            } else{
                mostrarMensaje("El técnico ha sido eliminado exitosamente");
            }
        }
    }

    public void mostrarTécnico(){
        if(controlador.getListaTécnicos().isEmpty()){
            System.out.println("No hay técnicos registrados");
        } else{
            mostrarTécnico(controlador.getListaTécnicos());
        }
    }

    public void mostrarTécnico(ArrayList<Técnico> técnicos){
        System.out.printf("%-20s %-20s %-20s %-10s\n", "Identificación", "Nombre", "Teléfono", "Especialidad");
        System.out.println(new String(new char[70]).replace("\0", "-"));
        for(Técnico técnico:técnicos){
            System.out.println(técnico);
        }
    }
    
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
}