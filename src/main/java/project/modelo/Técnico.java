package project.modelo;

public class Técnico extends Persona{
    private String especialidad;
    
    public Técnico(String i,String n,String t, String e){
        super(i, n, t);
        this.especialidad = e;
    }

    public String getEpecialidad(){
        return especialidad;
    }

    public void setEspecialidad(String e){
        this.especialidad = e;
    }

    public String toString(){
        return super.toString() + String.format("%-10s", especialidad);
    }
}
