package project;

import java.util.*;
import project.vista.*;
import project.controlador.*;
import project.modelo.TipoCliente;
import java.time.LocalDate;
import project.modelo.TipoVehiculo;
import project.controlador.ControladorTécnico;



public class Main {
    
    public static void main(String[] args) {
        VistaMenú vistaMenú = new VistaMenú();

        ControladorCliente controladorCliente = new ControladorCliente();
        ControladorProveedor controladorProveedor = new ControladorProveedor();
        ControladorTécnico controladorTécnico = new ControladorTécnico();
        ControladorServicio controladorServicio = new ControladorServicio();
        ControladorDetalleServicio controladorDetalleServicio = new ControladorDetalleServicio();
        ControladorOrdenServicio controladorOrdenServicio = new ControladorOrdenServicio(controladorCliente, controladorServicio, controladorDetalleServicio);
        ControladorFaltaInsumo controladorFaltaInsumo = new ControladorFaltaInsumo(controladorProveedor);
        ControladorFactura controladorFactura = new ControladorFactura(controladorOrdenServicio, controladorCliente);
        ControladorReporteIngresoServicio controladorReporteIngresoServicio = new ControladorReporteIngresoServicio(controladorOrdenServicio, controladorDetalleServicio);
        ControladorReporteAtencionTecnico controladorReporteAtencionTecnico = new ControladorReporteAtencionTecnico(controladorOrdenServicio, controladorDetalleServicio, controladorTécnico);
        
        //Inicialización
        inicializarApp(controladorCliente, controladorProveedor, controladorTécnico, controladorServicio, controladorOrdenServicio);
        
        VistaCliente vistaCliente = new VistaCliente(controladorCliente);
        VistaProveedor vistaProveedor = new VistaProveedor(controladorProveedor);
        VistaTécnico vistaTécnico = new VistaTécnico(controladorTécnico);
        VistaServicio vistaServicio = new VistaServicio(controladorServicio);
        VistaOrdenServicio vistaOrdenServicio = new VistaOrdenServicio(controladorOrdenServicio, controladorDetalleServicio);
        VistaFaltaInsumo vistaFaltaInsumo = new VistaFaltaInsumo(controladorFaltaInsumo);
        VistaFactura vistaFactura = new VistaFactura(controladorFactura);
        controladorFactura.setVistaFactura(vistaFactura);
        VistaReporteIngresoServicio vistaReporteIngresoServicio = new VistaReporteIngresoServicio(controladorReporteIngresoServicio);
        VistaReporteAtencionTecnico vistaReporteAtencionTecnico = new VistaReporteAtencionTecnico(controladorReporteAtencionTecnico);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Servicio Administrativo de Tecnicentro");
        System.out.println("Bienvenido");

        int opcion = 0;
        do {
            vistaMenú.menú();
            System.out.println("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    int opcion1 = 0;
                    do {
                        vistaCliente.mostrarClientes();
                        vistaCliente.administrarClientes();
                        System.out.println("Seleccione una opción: ");
                        opcion1 = scanner.nextInt();
                        switch (opcion1) {
                            case 1:
                                vistaCliente.agregarCliente(scanner);
                                break;
                            case 2:
                                System.out.println("Regresando al menú principal");
                                break;
                        }
                    } while (opcion1 != 2);
                    break;

                case 2:
                    int opcion2 = 0;
                    do {
                        vistaProveedor.mostrarProveedores();
                        vistaProveedor.administrarProveedores();
                        System.out.println("Seleccione una opción: ");
                        opcion2 = scanner.nextInt();
                        switch (opcion2) {
                            case 1:
                                vistaProveedor.agregarProveedor(scanner);
                                break;
                            case 2:
                                System.out.println("Regresando al menú principal");
                                break;
                        }
                    } while (opcion2 != 2);
                    break;

                case 3:
                    int opcion3 = 0;
                    do {
                        vistaTécnico.mostrarTécnico();
                        vistaTécnico.administrarTécnicos();
                        System.out.println("Seleccione una opción: ");
                        opcion3 = scanner.nextInt();
                        switch (opcion3) {
                            case 1:
                                vistaTécnico.agregarTécnico(scanner);
                                break;
                            case 2:
                                vistaTécnico.eliminarTécnico(scanner);
                                break;
                            case 3:
                                System.out.println("Regresando al menú principal");
                                break;
                        }
                    } while (opcion3 != 3);
                    break;

                case 4:
                    int opcion4 = 0;
                    do {
                        vistaServicio.mostrarServicios();
                        vistaServicio.administrarServicios();
                        System.out.println("Seleccione una opción: ");
                        opcion4 = scanner.nextInt();
                        switch (opcion4) {
                            case 1:
                                vistaServicio.agregarServicio(scanner);
                                break;
                            case 2:
                                vistaServicio.editarServicio(scanner);
                                break;
                            case 3:
                                System.out.println("Regresando al menú principal");
                                break;
                        }
                    } while (opcion4 != 3);
                    break;

                case 5:
                    vistaOrdenServicio.registrarOrden(scanner);
                    break;

                case 6:
                    vistaFaltaInsumo.registrarFalta(scanner);
                    break;

                case 7:
                    vistaFactura.generarFactura(scanner); 
                    break;

                case 8:
                    vistaReporteIngresoServicio.ReporteIngresoServicio(scanner);
                    break;

                case 9:
                    vistaReporteAtencionTecnico.ReporteAtencionTecnico(scanner);
                    break;

                case 10:
                    System.out.println("Saliendo de la aplicación");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 10);

        scanner.close();
    }
    
    public static void inicializarApp(
    ControladorCliente controladorCliente,
    ControladorProveedor controladorProveedor,
    ControladorTécnico controladorTécnico,
    ControladorServicio controladorServicio,
    ControladorOrdenServicio controladorOrdenServicio){
        int codigoServicio=1;
    // TÉCNICOS
        controladorTécnico.agregarTecnico("0101010101", "Álvaro López", "099999111", "Revisión de frenos");
        controladorTécnico.agregarTecnico("0202020202", "Mario Barcos", "088888222", "Cambio de aceite");

    //CLIENTES
        controladorCliente.agregarCliente("1717171717", "Juan Pérez", "Av. Siempre Viva 123", "0991234567", TipoCliente.Personal);
        controladorCliente.agregarCliente("1818181818", "Ana Torres", "Calle 10 y Av. 5", "0987654321", TipoCliente.Personal);
        controladorCliente.agregarCliente("0999999999", "Grupo HG S.A.", "Av. de las Empresas 321", "042334455", TipoCliente.Empresarial);
        controladorCliente.agregarCliente("0888888888", "Transporte SA", "Km 12 Vía Daule", "042112233", TipoCliente.Empresarial);

    //SERVICIOS
        controladorServicio.agregarServicio(codigoServicio++,"Cambio de aceite", 20.0);
        controladorServicio.agregarServicio(codigoServicio++,"Cambio de filtro", 15.0);
        controladorServicio.agregarServicio(codigoServicio++,"Alineación", 25.0);
        controladorServicio.agregarServicio(codigoServicio++,"Balanceo", 25.0);
        controladorServicio.agregarServicio(codigoServicio++,"Diagnóstico", 30.0);
        controladorServicio.agregarServicio(codigoServicio++,"Revisión de frenos", 35.0);

    //PROVEEDORES
        controladorProveedor.agregarProveedor("0606060606", "LubriOil", "0988123456", "Aceites y lubricantes");
        controladorProveedor.agregarProveedor("0707070707", "RefacSA", "0988765432", "Repuestos de motor");

    // Orden 1: cliente personal
        controladorOrdenServicio.generarOrdenServicio(
            "1717171717", LocalDate.of(2025, 7, 1), TipoVehiculo.Automovil,
                "ABC-123",new int[]{1, 2},new int[]{1, 1});

    // Orden 2: cliente empresarial
        controladorOrdenServicio.generarOrdenServicio(
        "0999999999",LocalDate.of(2025, 7, 2),TipoVehiculo.Bus,
                "BUS-101",new int[]{3, 4},new int[]{2, 2});

    // Orden 3: cliente empresarial
        controladorOrdenServicio.generarOrdenServicio(
        "0888888888",LocalDate.of(2025, 7, 4),TipoVehiculo.Bicicleta,
                "BIKE-99",new int[]{1, 5},new int[]{1, 1});

    // Orden 4: cliente personal
        controladorOrdenServicio.generarOrdenServicio(
        "1818181818",LocalDate.of(2025, 7, 5),TipoVehiculo.Automovil,
                "DEF-456",new int[]{4, 6},new int[]{1, 1});
    }

    
}
