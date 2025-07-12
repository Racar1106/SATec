package project.modelo;

import java.util.ArrayList;

public class Factura {
    private Cliente clienteEmpresarial;
    private int mes;
    private int año;
    private ArrayList<OrdenServicio> ordenes;

    public Factura(Cliente clienteEmpresarial, int mes, int año, ArrayList<OrdenServicio> ordenes){
        this.clienteEmpresarial = clienteEmpresarial;
        this.mes = mes;
        this.año = año;
        this.ordenes = ordenes;
    }

    public Cliente getCliente(){
        return clienteEmpresarial;
    }
    public int getMes(){
        return mes;
    }
    public int getAño(){
        return año;
    }

    public ArrayList<OrdenServicio> getOrdenes(){
        return ordenes;
    }
}
