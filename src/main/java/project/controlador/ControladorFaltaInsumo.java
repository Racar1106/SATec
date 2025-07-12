package project.controlador;

import java.util.ArrayList;
import java.util.List;
import project.modelo.FaltaInsumo;
import project.modelo.Proveedor;

public class ControladorFaltaInsumo {
    private ArrayList<FaltaInsumo> faltas;
    private ControladorProveedor controladorP;

    public ControladorFaltaInsumo(ControladorProveedor controladorProveedor){
        this.faltas = new ArrayList<>();
        this.controladorP = controladorProveedor;
    }

    public ArrayList<Proveedor> getProveedores(){
        return controladorP.getListaProveedores();
    }

    public void registrarFalta(String descripcion, String identificacionProveedor) {
        Proveedor seleccionado = null;
        for (Proveedor p : getProveedores()) {
            // Busca por la identificación que hereda de Persona
            if (p.getIdentificación().equals(identificacionProveedor)) {
                seleccionado = p;
                break;
            }
        }
        if (seleccionado != null) {
            FaltaInsumo falta = new FaltaInsumo(descripcion, seleccionado);
            faltas.add(falta);
            System.out.println("Falta registrada correctamente.");
        } else {
            System.out.println("Proveedor no encontrado.");
        }
    }

    public List<FaltaInsumo> getFaltasRegistradas() {
        return faltas;
    }
}

