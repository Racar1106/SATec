package project.controlador;

import java.util.ArrayList; 
import project.modelo.DetalleServicio;
import project.modelo.Servicio;

public class ControladorDetalleServicio {
    private ArrayList<DetalleServicio> detallesServicios = new ArrayList<>();

    public void crearDetalleServicio(Servicio s, int cantidad){
        for(DetalleServicio detalleServicio:detallesServicios){
            if(detalleServicio.getServicio().equals(s)){
                detalleServicio.setCantidad(detalleServicio.getCantidad()+cantidad);
                return;
            }
        }
        DetalleServicio ds = new DetalleServicio(s, cantidad);
        detallesServicios.add(ds);
    }

    public double calcularTotal(Servicio s, int cantidad){
        double subTotal = s.getPrecio()*cantidad;
        return subTotal;
    }

    public ArrayList<DetalleServicio> getDetalleServicios(){
        return detallesServicios;
    }

    public void clearDetalleServicio(){
        detallesServicios.clear();
    }
}
