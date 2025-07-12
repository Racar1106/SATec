package project.controlador;

import java.util.ArrayList;
import java.time.LocalDate;
import project.modelo.OrdenServicio;
import project.modelo.TipoVehiculo;
import project.modelo.Vehículo;
import project.modelo.Cliente;
import project.modelo.Servicio;
import project.modelo.DetalleServicio;

public class ControladorOrdenServicio {
    private ArrayList<OrdenServicio> listaOrdenes;
    private ControladorCliente controladorC;
    private ControladorDetalleServicio controladorDS;
    private ControladorServicio controladorS;

    public ControladorOrdenServicio(ControladorCliente controladorC, ControladorServicio controladorS, ControladorDetalleServicio controladorDS){
        listaOrdenes = new ArrayList<>();
        this.controladorC = controladorC;
        this.controladorS = controladorS;
        this.controladorDS = controladorDS;
    }

    public Vehículo crearVehículo(String p, String tv){
        TipoVehiculo tipoVehiculo = TipoVehiculo.valueOf(tv);
        Vehículo vehículo = new Vehículo(p, tipoVehiculo);
        return vehículo;
    }

    public LocalDate crearFecha(String fecha){
        String[] f = fecha.split("-");
        int año = Integer.valueOf(f[0]);
        int mes = Integer.valueOf(f[1]);
        int día = Integer.valueOf(f[2]);
        LocalDate nuevaFecha = LocalDate.of(año, mes, día);
        return nuevaFecha;
    }

    public OrdenServicio generarOrdenServicio(Cliente c, LocalDate f, Vehículo v, ArrayList<DetalleServicio> dS){
        OrdenServicio ordenServicio = new OrdenServicio(c, f, v, dS);
        listaOrdenes.add(ordenServicio);
        return ordenServicio;
    }

    public double valorTotal(OrdenServicio ordenServicio){
        double total = 0;
        for(DetalleServicio detalleServicio:ordenServicio.getListaDetalleServicio()){
            double subTotal = controladorDS.calcularTotal(detalleServicio.getServicio(), detalleServicio.getCantidad());
            total += subTotal;
        }
        return total;
    }

    public Cliente buscarCliente(String id){
        return controladorC.buscarCliente(id);
    }

    public Servicio buscarServicio(int código){
        return controladorS.buscarServicio(código);
    }

    public ArrayList<Servicio> getListaServicios(){
        return controladorS.getListaServicios();
    }

    public ArrayList<OrdenServicio> getListaOrdenServicios(){
        return listaOrdenes;
    }

    public ArrayList<Cliente> getListaClientes(){
        return controladorC.getListaClientes();
    }
    
    public void generarOrdenServicio(String idCliente, LocalDate fecha, TipoVehiculo tipoVehiculo, String placa, int[] codigosServicio, int[] cantidades) {
        Cliente cliente = controladorC.buscarCliente(idCliente);
        if (cliente == null) {
            System.out.println("Cliente no encontrado: " + idCliente);
            return;
        }

        Vehículo vehiculo = new Vehículo(placa, tipoVehiculo);
        ArrayList<DetalleServicio> detalles = new ArrayList<>();

        for (int i = 0; i < codigosServicio.length; i++) {
            Servicio servicio = controladorS.buscarServicio(codigosServicio[i]);
            if (servicio != null) {
                DetalleServicio detalle = new DetalleServicio(servicio, cantidades[i]);
                detalles.add(detalle);
            }
        }
        generarOrdenServicio(cliente, fecha, vehiculo, detalles);
    }

}  