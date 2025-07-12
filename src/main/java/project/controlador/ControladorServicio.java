package project.controlador;

import java.util.ArrayList;
import project.modelo.Servicio;
import project.vista.MensajeUsuario;

public class ControladorServicio {
    private ArrayList<Servicio> listaServicios;
    private ArrayList<Servicio> listaPrecios;

    public ControladorServicio(){
        listaServicios = new ArrayList<>();
    }

    public Servicio buscarServicio(int código){
        for(Servicio servicio:listaServicios){
            if(servicio.getCódigo()==código){
                return servicio;
            }
        }
        return null;
    }

    public MensajeUsuario agregarServicio(int c, String n, double p){
        if(buscarServicio(c)==null){
            Servicio servicio = new Servicio(c, n, p);
            listaServicios.add(servicio);
            return null;
        }
        return new MensajeUsuario("Agregar Servicio","El servicio ya existe");
    }

    public MensajeUsuario editarServicio(int c, double p){
        if(buscarServicio(c)!=null){
            Servicio servicio = buscarServicio(c);
            servicio.setPrecio(p);
            return null;
        }
        return new MensajeUsuario("Editar Servicio","El servicio no existe");
    }

    public ArrayList<Servicio> getListaServicios(){
        return listaServicios;
    }

    public ArrayList<Servicio> getListaPrecios(){
        return listaPrecios;
    }
    
    public void mostrarHistorialPrecios(int codigo) {
        Servicio servicio = buscarServicio(codigo);
            if (servicio != null) {
                System.out.println("Historial de precios para el servicio: " + servicio.getNombre());
                    for (Double precio : servicio.getHistorialPrecios()) {
                        System.out.println("- $" + precio);
                    }
            } else {
                System.out.println("Servicio no encontrado.");
            }
    }

}
