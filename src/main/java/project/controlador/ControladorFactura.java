package project.controlador;

import java.util.ArrayList;
import project.modelo.OrdenServicio;
import project.modelo.Cliente;
import project.modelo.Factura;
import project.modelo.TipoCliente;
import project.vista.VistaFactura;

public class ControladorFactura {
    private ControladorOrdenServicio controladorOS;
    private ControladorCliente controladorC;
    private VistaFactura vistaFactura; // Será inyectada luego

    public ControladorFactura(ControladorOrdenServicio controladorOS, ControladorCliente controladorC) {
        this.controladorOS = controladorOS;
        this.controladorC = controladorC;
    }

    public void setVistaFactura(VistaFactura vistaFactura){
        this.vistaFactura = vistaFactura;
    }

    public void generarFacturaEmpresarial(String cedulaEmpresa, int año, int mes) {
        Cliente cliente = controladorC.buscarCliente(cedulaEmpresa);

        if (cliente.getTipoCliente().equals(TipoCliente.Empresarial)) {
            ArrayList<OrdenServicio> ordenesFiltradas = new ArrayList<>();
            double totalPagar = 0;

            for (OrdenServicio orden : controladorOS.getListaOrdenServicios()) {
                if (orden.getCliente().getIdentificación().equals(cedulaEmpresa) && orden.getFecha().getYear() == año && orden.getFecha().getMonthValue() == mes) {
                    ordenesFiltradas.add(orden);
                    totalPagar += controladorOS.valorTotal(orden);
                }
            }

            totalPagar += 50; // Cargo fijo mensual empresarial

            Factura factura = new Factura(cliente, mes, año, ordenesFiltradas);

            vistaFactura.mostrarFactura(factura, totalPagar);
        }else{
            vistaFactura.mostrarMensaje("No se encontró una empresa con esa cédula o no es tipo empresarial.");
            return;
        }
    }
}