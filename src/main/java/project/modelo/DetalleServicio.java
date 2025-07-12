package project.modelo;

public class DetalleServicio {
    private Servicio servicio;
    private int cantidad;

    public DetalleServicio (Servicio servicio, int cantidad){
        this.servicio = servicio;
        this.cantidad = cantidad;
    }
    
    public Servicio getServicio(){
        return servicio;
    }
    public int getCantidad(){
        return cantidad;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
}
