package project.controlador;

import java.util.ArrayList;
import project.modelo.Cliente;
import project.modelo.TipoCliente;
import project.vista.MensajeUsuario;

public class ControladorCliente {
    private ArrayList<Cliente> listaClientes;

    public ControladorCliente(){
        listaClientes = new ArrayList<>();
    }

    public Cliente buscarCliente(String identificación){
        for(Cliente cliente:listaClientes){
            if(cliente.getIdentificación().equals(identificación)){
                return cliente;
            }
        }
        return null;
    }

    public MensajeUsuario agregarCliente(String i, String n, String d, String t, TipoCliente tipoCliente){
        if(buscarCliente(i)==null){
            Cliente cliente = new Cliente(i, n, d, t, tipoCliente);
            listaClientes.add(cliente);
            return null;
        }
        return new MensajeUsuario("Agregar Cliente", "El cliente ya existe");
    }

    public ArrayList<Cliente> getListaClientes(){
        return listaClientes;
    }
}
