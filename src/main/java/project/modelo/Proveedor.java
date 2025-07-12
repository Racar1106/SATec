package project.modelo;

public class Proveedor extends Persona{
    private String descripción;
    
    public Proveedor(String i,String n,String t,String d){
        super(i, n, t);
        this.descripción = d;
    }

    public String getDescripción(){
        return descripción;
    }
    public void setDescripción(String d){
        this.descripción = d;
    }

    public String toString(){
        return super.toString() + String.format("%-10s", descripción);
    }
}
