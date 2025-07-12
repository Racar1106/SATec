package project.modelo;

public class Persona {
    private String identificación;
    private String nombre;
    private String teléfono;

    public Persona(String i,String n,String t){
        this.identificación = i;
        this.nombre = n;
        this.teléfono = t;
    }

    public String getIdentificación(){
        return identificación;
    }
    public String getNombre(){
        return nombre;
    }
    public String getTeléfono(){
        return teléfono;
    }

    public void setIdentificación(String i){
        this.identificación = i;
    }
    public void setNombre(String n){
        this.nombre = n;
    }
    public void setTeléfono(String t){
        this.teléfono = t;
    }

    public String toString(){
        return String.format("%-20s %-20s %-21s", identificación, nombre, teléfono);
    }
}
