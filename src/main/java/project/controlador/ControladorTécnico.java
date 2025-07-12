package project.controlador;

import java.util.ArrayList;
import project.modelo.Técnico;
import project.vista.MensajeUsuario;

public class ControladorTécnico {
    private ArrayList<Técnico> listaTécnicos;

    public ControladorTécnico(){
        listaTécnicos = new ArrayList<>();
    }

    private Técnico buscarTécnico(String identificación){
        for(Técnico técnico:listaTécnicos){
            if(técnico.getIdentificación().equals(identificación)){
                return técnico;
            }
        }
        return null;
    }

    public MensajeUsuario agregarTecnico(String i, String n, String t, String e){
        if(buscarTécnico(i)==null){
            Técnico técnico = new Técnico(i, n, t, e);
            listaTécnicos.add(técnico);
            return null;
        }
        return new MensajeUsuario("Agregar Técnico","El Técnico ya existe");
    }

    public MensajeUsuario eliminarTécnico(String i){
        if(buscarTécnico(i)!=null){
            Técnico técnico = buscarTécnico(i);
            listaTécnicos.remove(técnico);
            return null;
        }
        return new MensajeUsuario("Eliminar Técnico", "El técnico no existe");
    }
    
    public ArrayList<Técnico> getListaTécnicos(){
        return listaTécnicos;
    }
}
