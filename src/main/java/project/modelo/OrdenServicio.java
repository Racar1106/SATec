package project.modelo;

import java.util.ArrayList;
import java.time.LocalDate;

public class OrdenServicio {
    private Cliente cliente;
    private LocalDate fecha;
    private Vehículo vehículo;
    private ArrayList<DetalleServicio> detallesServicios;

    public OrdenServicio(Cliente c, LocalDate f, Vehículo v, ArrayList<DetalleServicio> dS){
        this.cliente = c;
        this.fecha = f;
        this.vehículo = v;
        this.detallesServicios = new ArrayList<>(dS);
    }

    public Cliente getCliente(){
        return cliente;
    }
    public LocalDate getFecha(){
        return fecha;
    }
    public Vehículo getVehículo(){
        return vehículo;
    }
    public ArrayList<DetalleServicio> getListaDetalleServicio(){
        return detallesServicios;
    }
}
