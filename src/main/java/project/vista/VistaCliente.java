package project.vista;

import java.util.Scanner;
import java.util.ArrayList;
import project.controlador.ControladorCliente;
import project.modelo.Cliente;
import project.modelo.TipoCliente;

public class VistaCliente {
    ControladorCliente controlador;
    public VistaCliente(ControladorCliente controlador){
        this.controlador = controlador;
    }

    public void administrarClientes(){
        System.out.println("Administrar clientes");
        System.out.println("1. Agregar Cliente");
        System.out.println("2. Regresar al menú principal");
    }

    public void agregarCliente(Scanner scanner){
        scanner.nextLine();
        System.out.println("Ingrese la identificación del cliente: ");
        String identificación = scanner.nextLine();
        System.out.println("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la dirección del cliente: ");
        String dirección = scanner.nextLine();
        System.out.println("Ingrese el teléfono del cliente: ");
        String teléfono = scanner.nextLine();
        TipoCliente tipoCliente= null;
        while (tipoCliente == null){
            System.out.println("Ingrese el tipo de Cliente (Personal O Empresarial): ");
            String tipoTexto= scanner.nextLine();
            try{
                tipoCliente= TipoCliente.valueOf(tipoTexto);
            }catch(IllegalArgumentException e){
                System.out.println("Tipo inválido. Intente nuevamente");
            }
        }
        MensajeUsuario m=controlador.agregarCliente(identificación, nombre, dirección, teléfono, tipoCliente);
        if(m!=null){
            mostrarMensaje(m.toString());
        }else{
            mostrarMensaje("Cliente agregado");
        }
    }

    public void mostrarClientes(){
        if(controlador.getListaClientes().isEmpty()){
            System.out.println("No hay clientes registrados");
        } else{
            mostrarClientes(controlador.getListaClientes());
        }
    }

    public void mostrarClientes(ArrayList<Cliente> clientes){
        System.out.printf("%-20s %-20s %-20s %-25s %-20s\n", "Identificación", "Nombre", "Teléfono", "Dirección", "Tipo de Cliente");
        System.out.println(new String(new char[99]).replace("\0", "-"));
        for(Cliente cliente:clientes){
            System.out.println(cliente);
        }
    }

    
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
}
