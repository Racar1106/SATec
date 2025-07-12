package project.controlador;

import java.util.ArrayList;

import project.modelo.DetalleServicio;
import project.modelo.OrdenServicio;
import project.modelo.Servicio;
import project.modelo.Técnico;

public class ControladorReporteAtencionTecnico {
    private ArrayList<DetalleServicio> ordenesFiltradas;
    private ControladorOrdenServicio controladorOS;
    private ControladorDetalleServicio controladorDS;
    private ControladorTécnico controladorT;
    
    public ControladorReporteAtencionTecnico(ControladorOrdenServicio controladorOS, ControladorDetalleServicio controladorDS, ControladorTécnico controladorT){
        this.controladorOS = controladorOS;
        this.controladorDS = controladorDS;
        this.controladorT = controladorT;
    }

    public ArrayList<DetalleServicio> getListaFiltrada(int año, int mes){
        ordenesFiltradas = new ArrayList<>();

        for (OrdenServicio orden : controladorOS.getListaOrdenServicios()) {
            if (orden.getFecha().getYear() == año && orden.getFecha().getMonthValue() == mes) {
                for(DetalleServicio detalleServicio : orden.getListaDetalleServicio()){
                    ordenesFiltradas.add(detalleServicio);
                }
            }
        }
        return ordenesFiltradas;
    }  

    public double getTotalTecnico(Técnico técnico, ArrayList<DetalleServicio> ordenesFiltradas){
        double total = 0;
        for(DetalleServicio detalleServicio : ordenesFiltradas){
            if(detalleServicio.getServicio().getNombre()==técnico.getEpecialidad()){
                double subTotal = getTotalServicio(detalleServicio.getServicio(), detalleServicio.getCantidad());
                total += subTotal;
            }
        }
        return total;
    }

    public double getTotalServicio(Servicio servicio, int cantidad){
        return controladorDS.calcularTotal(servicio, cantidad);
    }

    public ArrayList<Técnico> getListaTécnicos(){
        return controladorT.getListaTécnicos();
    }
}
