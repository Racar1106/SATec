package project.vista;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import project.controlador.ControladorOrdenServicio;
import project.controlador.ControladorDetalleServicio;
import project.modelo.OrdenServicio;
import project.modelo.Vehículo;
import project.modelo.Cliente;
import project.modelo.Servicio;

public class VistaOrdenServicio {
    ControladorOrdenServicio controlador;
    ControladorDetalleServicio controladorDS;

    public VistaOrdenServicio(ControladorOrdenServicio controlador, ControladorDetalleServicio controladorDS){
        this.controlador = controlador;
        this.controladorDS = controladorDS;
    }

    public void registrarOrden(Scanner scanner){
        scanner.nextLine();
        controladorDS.clearDetalleServicio();
        System.out.println("=== Generar orden de servicios ===");
        mostrarClientes();
        System.out.println("Ingrese la identificación del cliente: ");
        String id = scanner.nextLine();

        System.out.println("Fecha del servicio (yyyy-mm-dd): ");
        String f = scanner.nextLine();

        System.out.println("Ingrese el tipo de vehículo (Automovil, Camioneta, Bus, Bicicleta):");
        String tipoVehículo = scanner.nextLine();

        System.out.println("Ingrese la placa del vehículo: ");
        String placa = scanner.nextLine();

        LocalDate fecha = controlador.crearFecha(f);
        Vehículo vehículo = controlador.crearVehículo(placa, tipoVehículo);
        Cliente cliente = controlador.buscarCliente(id);

        int opción = 0;
        mostrarListaServicio();
        while(opción!=-1){
            System.out.println("Ingrese el código del servicio: ");
            int codigo = scanner.nextInt();
            if(codigo==-1){
                opción = -1;
                return;
            }
            
            System.out.println("Ingrese la cantidad: ");
            int cantidad = scanner.nextInt();

            if(controlador.buscarServicio(codigo)!=null){
                Servicio s = controlador.buscarServicio(codigo);
                controladorDS.crearDetalleServicio(s, cantidad);
            } else{
                System.out.println("El código del servicio que ingresó no existe");
            }
        }
        OrdenServicio ordenServicio = controlador.generarOrdenServicio(cliente, fecha, vehículo, controladorDS.getDetalleServicios());
        controlador.valorTotal(ordenServicio);
        controladorDS.clearDetalleServicio();
    }

    public void mostrarListaServicio(){
        if(controlador.getListaServicios().isEmpty()){
            System.out.println("No hay servicios registrados");
        } else{
            mostrarListaServicio(controlador.getListaServicios());
        }
    }

    public void mostrarListaServicio(ArrayList<Servicio> listaServicios){
        System.out.printf("%-10s %-20s %-20s %-10s\n", "#","Código", "Nombre", "Precio");
        System.out.println(new String(new char[40]).replace("\0", "-"));
        int valor = 1;
        for(Servicio servicio:listaServicios){
            System.out.printf("%-10s %-20s %-20s %-10s\n", valor,servicio.getCódigo(),servicio.getNombre(),servicio.getPrecio());
            valor ++;
        }
        System.out.println("-1: Salir");
    }

    public void mostrarClientes(){
        if(controlador.getListaClientes().isEmpty()){
            System.out.println("No hay clientes registrados");
        } else{
            mostrarClientes(controlador.getListaClientes());
        }
    }

    public void mostrarClientes(ArrayList<Cliente> listaClientes){
        System.out.printf("%-20s %-20s %-10s\n", "Código", "Nombre", "Tipo de Cliente");
        System.out.println(new String(new char[40]).replace("\0", "-"));
        for(Cliente cliente:listaClientes){
            System.out.printf("%-20s %-20s %-10s\n",cliente.getIdentificación(),cliente.getNombre(),cliente.getTipoCliente());
        }
    }
}
