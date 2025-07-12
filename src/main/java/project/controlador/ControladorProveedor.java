package project.controlador;

import java.util.ArrayList;
import project.modelo.Proveedor;
import project.vista.MensajeUsuario;

public class ControladorProveedor {
    public static ArrayList<Proveedor> listaProveedores;

    public ControladorProveedor(){
        listaProveedores = new ArrayList<>();
    }

    private Proveedor buscarProveedor(String identificación){
        for(Proveedor proveedor:listaProveedores){
            if(proveedor.getIdentificación().equals(identificación)){
                return proveedor;
            }
        }
        return null;
    }

    public MensajeUsuario agregarProveedor(String i, String n, String t, String d){
        if(buscarProveedor(i)==null){
            Proveedor proveedor = new Proveedor(i, n, t, d);
            listaProveedores.add(proveedor);
            return null;
        }
        return new MensajeUsuario("Agregar Proveedor","El proveedor ya existe");
    }

    public ArrayList<Proveedor> getListaProveedores(){
        return listaProveedores;
    }
}
