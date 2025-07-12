package project.controlador;

import java.util.ArrayList;

import project.modelo.DetalleServicio;
import project.modelo.OrdenServicio;
import project.modelo.Servicio;

public class ControladorReporteIngresoServicio {
    private ArrayList<DetalleServicio> ordenesFiltradas;
    private ControladorOrdenServicio controladorOS;
    private ControladorDetalleServicio controladorDS;

    public ControladorReporteIngresoServicio(ControladorOrdenServicio controladorOS, ControladorDetalleServicio controladorDS){
        this.controladorOS = controladorOS;
        this.controladorDS = controladorDS;
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

    public double getTotalServicio(Servicio servicio, int cantidad){
        return controladorDS.calcularTotal(servicio, cantidad);
    }
}
