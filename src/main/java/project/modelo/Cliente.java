package project.modelo;

public class Cliente extends Persona{
    private String dirección;
    private TipoCliente tipoCliente;
    
    public Cliente(String i,String n,String d,String t, TipoCliente tc){
        super(i, n, t);
        this.dirección = d;
        this.tipoCliente = tc;
    }

    public String getDirección(){
        return dirección;
    }
    public TipoCliente getTipoCliente(){
        return tipoCliente;
    }

    public void setDirección(String d){
        this.dirección = d;
    }
    public void setTipoCliente(TipoCliente tc){
        this.tipoCliente = tc;
    }

    public String toString(){
        return super.toString() + String.format("%-26s %-20s", dirección, tipoCliente);
    }
}
