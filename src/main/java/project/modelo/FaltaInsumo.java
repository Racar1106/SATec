package project.modelo;

public class FaltaInsumo {
    private String descripcion;
    private Proveedor proveedor;

    public FaltaInsumo(String descripcion, Proveedor proveedor) {
        this.descripcion = descripcion;
        this.proveedor = proveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    @Override
    public String toString() {
        return "Falta: " + descripcion + ", Proveedor: " + proveedor.getIdentificación() + " - " + proveedor.getNombre();
    }
}

